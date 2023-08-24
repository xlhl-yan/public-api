package com.yupi.project.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * InterfaceInfoInvokeRequest
 *
 * @author xlhl
 * @version 1.0
 * @description 测试接口调用请求参数封装
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户传递的请求参数
     * 例：{"username": string,"type": string}
     */
    private String userRequestParams;


    private static final long serialVersionUID = 1L;
}
