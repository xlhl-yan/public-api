package com.xlhl.publicinterface;

import com.xlhl.publicapiclientsdk.clint.PublicApiClient;
import com.xlhl.publicapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class PublicInterfaceApplicationTests {

    @Resource
    private PublicApiClient publicApiClient;

    @Test
    void contextLoads() {
        String xlhl = publicApiClient.getNameByGet("xlhl");
        System.out.println("xlhl = " + xlhl);
        User user = new User();
        user.setUsername("xlhl");
        String name = publicApiClient.getName(user);
        System.out.println("name = " + name);
        String post = publicApiClient.getNameByPost("xlhl");
        System.out.println("post = " + post);
    }

}
