package com.yupi.project.model.dto.userinterfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @author xlhl
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {


    /**
     * 调用人
     */
    private Long userId;

    /**
     * 接口id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;



    private static final long serialVersionUID = 1L;
}