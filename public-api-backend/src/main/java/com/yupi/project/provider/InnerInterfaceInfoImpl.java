package com.yupi.project.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.InterfaceInfoMapper;
import com.yupi.project.model.entity.InterfaceInfo;
import com.yupi.project.model.enums.InterfaceInfoStatusEnum;
import com.yupi.project.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * InnerInterfaceInfoImpl
 *
 * @author xlhl
 * @version 1.0
 * @description 内部获取接口信息实现
 */
@DubboService
public class InnerInterfaceInfoImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("url", url);
        wrapper.eq("method", method.toUpperCase(Locale.ROOT));
        wrapper.eq("status", InterfaceInfoStatusEnum.ONLINE.getValue());
        return interfaceInfoMapper.selectOne(wrapper);
    }

}
