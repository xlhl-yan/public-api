package com.xlhl.publicapiclientsdk.clint;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xlhl.publicapiclientsdk.utils.SignUtils;
import com.yupi.project.model.entity.User;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * PublicClient
 *
 * @author xlhl
 * @version 1.0
 * @description 调用第三方接口
 */
@Data
public class PublicApiClient {
    private static final String GATEWAY_HOST = "http://127.0.0.1:8082";

    private String secretKey;
    private String accessKey;

    public PublicApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("name", name);

        return HttpUtil.get(GATEWAY_HOST + "/api/name", paramMap);
    }

    public String getName(User user) {
        String json = JSONUtil.toJsonStr(user);

        return HttpRequest.post(GATEWAY_HOST + "/api/name")
                .body(json)
                .addHeaders(getHeader(user.toString()))
                .execute().body();
    }

    public String getNameByPost(String name) {
        return HttpUtil.post(String.format(GATEWAY_HOST + "/api/name/%s", name), "");
    }

    private Map<String, String> getHeader(String body) {
        HashMap<String, String> header = new HashMap<>(16);
        header.put("accessKey", accessKey);
        //密码不要发送给后端，被截胡就无了
        //        header.put("secretKey", secretKey);
        header.put("nonce", RandomUtil.randomNumbers(4));
        String json = JSONUtil.toJsonStr(body);
        header.put("body", json);
        header.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        header.put("sign", SignUtils.getSign(body, secretKey));
        return header;
    }


}
