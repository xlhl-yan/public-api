package com.yupi.project.service;


import com.yupi.project.model.entity.User;

/**
 * 內部用户服务
 *
 * @author yupi
 */
public interface InnerUserService {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);


    /**
     * 从数据库中查询查询是否存在用户
     *
     * @param ak accessKey
     * @param sk secretKey
     * @return 用户信息
     */
    User getInvokeUser(String ak, String sk);
}
