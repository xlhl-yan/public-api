package com.yupi.project.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserInterfaceInfoMapper;
import com.yupi.project.model.entity.UserInterfaceInfo;
import com.yupi.project.model.enums.InterfaceInfoStatusEnum;
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

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Override
    public Boolean invokeCount(Long interfaceInfoId, Long userId) {

        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public Integer userCallInterfaceNum(Long interfaceInfoId, Long userId) {
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interfaceInfoId", interfaceInfoId);
        queryWrapper.eq("userId", userId);
        queryWrapper.eq("status", InterfaceInfoStatusEnum.OFFLINE.getValue());
        queryWrapper.gt("leftNum", 0);
        return userInterfaceInfoMapper.selectCount(queryWrapper).intValue();
    }
}
