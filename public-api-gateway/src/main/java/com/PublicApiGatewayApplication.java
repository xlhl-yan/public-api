package com;

import com.yupi.project.provider.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xlhl
 */
@SpringBootApplication
@EnableDubbo
public class PublicApiGatewayApplication {

    @DubboReference
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(PublicApiGatewayApplication.class, args);

    }

    {
        System.out.println(demoService.sayHello("AzurLane"));
        System.out.println(demoService.sayHello2("Helena"));
    }
}
