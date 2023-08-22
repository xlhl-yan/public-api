package com.yupi.project.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 * @author xlhl
 */
@Data
public class InterfaceInfoUpdateRequest implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 请求参数
     * 例：{"username": string,"type": string}
     */
    private String requestParams;

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
     * 接口状态 0-关闭 1-开启
     */
    private Integer status;

    /**
     * 响应头
     */
    private String responseHeader;


    private static final long serialVersionUID = 1L;
}