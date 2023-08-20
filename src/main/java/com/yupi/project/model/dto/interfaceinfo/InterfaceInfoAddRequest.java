package com.yupi.project.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @author xlhl
 */
@Data
public class InterfaceInfoAddRequest implements Serializable {

    /**
     * 接口名称
     */
    private String name;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 接口路径
     */
    private String method;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 接口描述
     */
    private String description;

    /**
     * 接口上传人
     */
    private Long userId;

    /**
     * 响应头
     */
    private String responseHeader;

    private static final long serialVersionUID = 1L;
}