package com.yupi.project.service;


import com.yupi.project.model.entity.User;

/**
 * 內部用户服务
 *
 * @author yupi
 */
public interface InnerUserService {

    /**
     * 从数据库中查询查询是否存在用户
     *
     * @param ak accessKey
     * @return 用户信息
     */
    User getInvokeUser(String ak);

}
