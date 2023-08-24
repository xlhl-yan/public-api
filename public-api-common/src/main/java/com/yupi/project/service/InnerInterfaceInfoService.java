package com.yupi.project.service;

import com.yupi.project.model.entity.InterfaceInfo;

/**
 * @author xlhl
 * @description 针对表【interface_info(接口信息表)】的数据库操作Service
 * @createDate 2023-08-20 17:27:46
 */
public interface InnerInterfaceInfoService {

    /**
     * 根据请求路径，请求方法查询接口信息
     *
     * @param path   接口路径
     * @param method 请求方法
     * @return 接口信息
     */
    InterfaceInfo getInterfaceInfo(String path, String method);

    /**
     * 参数校验
     *
     * @param interfaceInfo 参数封装体
     * @param add           是否为添加请求
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
