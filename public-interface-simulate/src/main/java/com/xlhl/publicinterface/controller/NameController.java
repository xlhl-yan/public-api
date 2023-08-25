package com.xlhl.publicinterface.controller;

import com.yupi.project.model.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * NameController
 *
 * @author xlhl
 * @version 1.0
 * @description 模拟查询名称接口
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping
    public String getNameByGet(String name, HttpServletRequest request) {

        System.out.println("AzurLane = " + request.getHeader("AzurLane"));
        return String.format("getNameByGet->你的名字是：%s", name);
    }

    @PostMapping
    public String getName(@RequestBody User user, HttpServletRequest request) {
//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//        String body = request.getHeader("body");
//        if (!Objects.equals("AzurLane", accessKey)) {
//            throw new RuntimeException("无权限");
//        }
//        if (Long.parseLong(nonce) > 10000) {
//            throw new RuntimeException("无权限");
//        }
//
//        // 获取5分钟前的时间 判断时间戳是否过期
//        Calendar beforeTime = Calendar.getInstance();
//        beforeTime.add(Calendar.MINUTE, -5);
//        Date beforeDate = beforeTime.getTime();
//        long oldTime = beforeDate.getTime();
//        if (Long.parseLong(timestamp) < oldTime / 1000) {
//            throw new RuntimeException("无权限");
//        }
//        String serverSign = SignUtils.getSign(body, "Helena");
//        if (!Objects.equals(serverSign, sign)) {
//            throw new RuntimeException("无权限");
//        }
        return String.format("getName->你的名字是：%s", user.getUserName());
    }

    @PostMapping("/{name}")
    public String getNameByPost(@PathVariable("name") String name) {
        return String.format("getNameByPost->你的名字是：%s", name);
    }
}
