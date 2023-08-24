package com.yupi;

import com.yupi.project.provider.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author xlhl
 */
@SpringBootApplication
@EnableDubbo
@Component
public class PublicApiGatewayApplication {

    @DubboReference
    private DemoService demoService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PublicApiGatewayApplication.class, args);
        PublicApiGatewayApplication bean = context.getBean(PublicApiGatewayApplication.class);
        System.out.println("bean.doSayHello() = " + bean.doSayHello());
    }

    public String doSayHello() {
        System.out.println(demoService.sayHello("AzurLane"));
        System.out.println(demoService.sayHello2("Helena"));
        return demoService.sayHello("xlhl");
    }
}
