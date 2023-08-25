package com.yupi.project.service;


/**
 * @author xlhl
 * @description 针对表【user_interface_info(用户调用接口)】的数据库操作Service
 * @createDate 2023-08-22 16:53:13
 */
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     *
     * @param interfaceInfoId 接口id
     * @param userId          调用者id
     * @return 数据库修改行数
     */
    Boolean invokeCount(Long interfaceInfoId, Long userId);


    /**
     * 获取用户对应接口的剩余调用调用次数
     *
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    Integer userCallInterfaceNum(Long interfaceInfoId, Long userId);
}
