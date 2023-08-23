package com.yupi.project.filter;

import com.xlhl.publicapiclientsdk.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.*;


/**
 * 全局过滤
 *
 * @author xlhl
 * # @Order 过滤器索引，越小优先级越高
 */
@Slf4j
@Component
@Order(-1)
public class CustomGlobalFilter implements GlobalFilter {

    private static final List<String> IP_WHITE_LIST = Collections.singletonList("127.0.0.1");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        1. 日志
        ServerHttpRequest request = exchange.getRequest();
        log.info("请求的唯一标识：{}", request.getId());
        log.info("请求的路径：{}", request.getPath().value());
        log.info("请求的方法：{}", request.getMethod());
        log.info("请求的json方法体：{}", request.getBody());
        log.info("请求的方法参数：{}", request.getQueryParams());
        String host = Objects.requireNonNull(request.getLocalAddress()).getHostString();
        log.info("请求的ip地址：{}", host);
        ServerHttpResponse response = exchange.getResponse();

//        2. （白名单）
        if (!IP_WHITE_LIST.contains(host)) {
            // 返回
            return handleNoAuth(response);
        }

//        3. 用户鉴权（判断ak、sk是否合法）
        HttpHeaders headers = request.getHeaders();

        String accessKey = headers.getFirst("accessKey");
        String nonce = headers.getFirst("nonce");
        String timestamp = headers.getFirst("timestamp");
        String sign = headers.getFirst("sign");
        String body = headers.getFirst("body");

        //todo 数据库中查询 accessKey是否存在
        if (!Objects.equals("AzurLane", accessKey)) {
            return handleNoAuth(response);
        }
        if (Long.parseLong(Objects.requireNonNull(nonce)) > 10000) {
            return handleNoAuth(response);
        }


        // 判断是否过期
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, -5);
        Date beforeDate = beforeTime.getTime();
        long oldTime = beforeDate.getTime();
        if (Long.parseLong(Objects.requireNonNull(timestamp)) < oldTime / 1000) {
            throw new RuntimeException("无权限");
        }
        // todo secretKey 是从数据库中查询获取 根据上面 accessKey
        String serverSign = SignUtils.getSign(body, "Helena");
        if (!Objects.equals(serverSign, sign)) {
            return handleNoAuth(response);
        }

//        4. 请求的模拟接口是否存在
//      todo 从数据库中查询模拟接口是否存在，以及请求方法是否匹配（请求参数是否相同） Feign远程调用

//        5. 调用模拟接口（请求转发）

//        6. 响应日志
        return handlerResponseLog(exchange, chain);
    }

    /**
     * 处理响应
     * <p>
     * 成功；接口调用次数 + 1
     * 失败；返回一个规范的错误码
     *
     * @param exchange
     * @param chain
     * @return
     */
    public Mono<Void> handlerResponseLog(ServerWebExchange exchange, GatewayFilterChain chain) {
        try {
            ServerHttpResponse originalResponse = exchange.getResponse();
            //  缓存数据 工厂
            DataBufferFactory bufferFactory = originalResponse.bufferFactory();

            //  拿到响应码
            HttpStatus statusCode = originalResponse.getStatusCode();
            if (statusCode == HttpStatus.OK) {
                //  装饰、增强能力
                ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
                    //  等待调用完转发的接口后才会执行
                    @Override
                    public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                        log.info("body instanceof Flux: {}", (body instanceof Flux));
                        if (body instanceof Flux) {
                            Flux<? extends DataBuffer> fluxBody = Flux.from(body);
                            //  往返回值中撰写结果
                            //  拼接字符串
                            return super.writeWith(
                                    fluxBody.map(dataBuffer -> {
                                        //  todo 7.调用成功，调用接口次数 + 1 invokeCount

                                        byte[] content = new byte[dataBuffer.readableByteCount()];
                                        dataBuffer.read(content);
                                        //释放掉内存
                                        DataBufferUtils.release(dataBuffer);
                                        // 构建日志
                                        StringBuilder sb2 = new StringBuilder(200);
                                        List<Object> rspArgs = new ArrayList<>();
                                        rspArgs.add(originalResponse.getStatusCode());
                                        //  rspArgs.add(requestUrl);

                                        //  data    content 响应结果
                                        String data = new String(content, StandardCharsets.UTF_8);
                                        sb2.append(data);
                                        //  打印日志
                                        log.info("响应结果是：{}", data);
                                        log.info("sb2：{}", sb2);
                                        return bufferFactory.wrap(content);
                                    })
                            );
                        } else {
                            handleInvokeError(originalResponse);
                            log.error("<--- {} 响应code异常", getStatusCode());
                        }
                        return super.writeWith(body);
                    }
                };
                //  设置 response 对象为装饰过后的
                return chain.filter(exchange.mutate().response(decoratedResponse).build());
            }
            return chain.filter(exchange);
            //  降级处理返回数据
        } catch (Exception e) {
            log.error("网关处理响应异常" + e);
            return chain.filter(exchange);
        }
    }

    private Mono<Void> handleNoAuth(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.FORBIDDEN);
        // 返回
        return response.setComplete();
    }

    private Mono<Void> handleInvokeError(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        // 返回
        return response.setComplete();
    }
}