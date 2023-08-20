package com.yupi.project.service;

import com.yupi.project.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author xlhl
 * @description 针对表【interface_info(接口信息表)】的数据库操作Service
 * @createDate 2023-08-20 17:27:46
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 参数校验
     *
     * @param interfaceInfo 参数封装体
     * @param add           是否为添加请求
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
