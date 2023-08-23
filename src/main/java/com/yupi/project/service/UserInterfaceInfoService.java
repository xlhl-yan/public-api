package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.project.model.entity.UserInterfaceInfo;

/**
 * @author xlhl
 * @description 针对表【user_interface_info(用户调用接口)】的数据库操作Service
 * @createDate 2023-08-22 16:53:13
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    /**
     * 参数校验
     *
     * @param interfaceInfo 参数封装体
     * @param add           是否为添加请求
     */
    void validUserInterfaceInfo(UserInterfaceInfo interfaceInfo, boolean add);

    /**
     * 调用接口统计
     *
     * @param interfaceInfoId 接口id
     * @param userId          调用者id
     * @return 数据库修改行数
     */
    Boolean invokeNumAdd(Long interfaceInfoId, Long userId);
}
