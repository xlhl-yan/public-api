package com.xlhl.publicapiclientsdk.model;

import lombok.Data;

import java.io.Serializable;

/**
 * User
 *
 * @author xlhl
 * @version 1.0
 * @description 模拟用户属性
 */
@Data
public class User implements Serializable {

    private static Long serialVersionUID = 1L;

    private String username;
}
