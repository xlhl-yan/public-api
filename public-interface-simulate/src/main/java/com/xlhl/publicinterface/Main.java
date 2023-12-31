package com.xlhl.publicinterface;

import com.xlhl.publicapiclientsdk.clint.PublicApiClient;
import com.yupi.project.model.entity.User;


/**
 * Main
 *
 * @author xlhl
 * @version 1.0
 * @description 调用主类
 */
public class Main {
    public static void main(String[] args) {
        String accessKey = "AzurLane";
        String secretKey = "Helena";

        PublicApiClient publicClient = new PublicApiClient(accessKey, secretKey);
        User user = new User();
        user.setUserName("xlhl");
        String result = publicClient.getName(user);

        System.out.println("getName = " + result);
    }
}
