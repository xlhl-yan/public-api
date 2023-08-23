package com.xlhl.publicinterface.aop;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * InvokeCountAop
 *
 * @author xlhl
 * @version 1.0
 * @description 统计调用次数切面
 */
@RestControllerAdvice
public class InvokeCountAop {

//    @Resource
//    private UserInterfaceInfoService userInterfaceInfoService;

    // 伪代码
    // 定义切面触发的时机（什么时候执行方法）controller方法执行成功后执行doInvokeCount

//    public void doInvokeCount(){
//        // 调用方法
//        object.proceed();
//        // 调用方法成功次数 + 1
//        userInterfaceInfoService.invokeCount();
//    }
}
