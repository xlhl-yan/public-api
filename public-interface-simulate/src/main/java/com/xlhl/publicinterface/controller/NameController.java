package com.xlhl.publicinterface.controller;

import com.xlhl.publicapiclientsdk.model.User;
import com.xlhl.publicapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

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
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        //todo 数据库中查询 accessKey是否存在
        if (!Objects.equals("AzurLane", accessKey)) {
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
        // todo secretKey 是从数据库中查询获取 根据上面 accessKey

        // 获取5分钟前的时间 判断时间戳是否过期
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, -5);
        Date beforeDate = beforeTime.getTime();
        long oldTime = beforeDate.getTime();
        if (Long.parseLong(timestamp) < oldTime / 1000) {
            throw new RuntimeException("无权限");
        }
        String serverSign = SignUtils.getSign(body, "Helena");
        if (!Objects.equals(serverSign, sign)) {
            throw new RuntimeException("无权限");
        }
        String result = String.format("getName->你的名字是：%s", user.getUsername());
        // todo 调用成功后，次数 + 1

        return result;
    }

    @PostMapping("/{name}")
    public String getNameByPost(@PathVariable("name") String name) {
        return String.format("getNameByPost->你的名字是：%s", name);
    }
}
