package com.yupi.project.provider;

import com.yupi.project.service.InnerUserInterfaceInfoService;
import com.yupi.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * InnerUserInterfaceInfoImpl
 *
 * @author xlhl
 * @version 1.0
 * @description 奇怪的实现类
 */
@DubboService
public class InnerUserInterfaceInfoImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public Boolean invokeCount(Long interfaceInfoId, Long userId) {

        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
}
