package com.yupi.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.InterfaceInfoMapper;
import com.yupi.project.model.entity.InterfaceInfo;
import com.yupi.project.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * @author xlhl
 * @description 针对表【interface_info(接口信息表)】的数据库操作Service实现
 * @createDate 2023-08-20 17:27:46
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        String url = interfaceInfo.getUrl();
        String method = interfaceInfo.getMethod();
        String requestHeader = interfaceInfo.getRequestHeader();
        String description = interfaceInfo.getDescription();
        String responseHeader = interfaceInfo.getResponseHeader();


        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name, url, method)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称、路径、请求方法是必须的");
            }
        }
        //非创建请求参数校验
        if (StringUtils.isAllBlank(name, url, method, requestHeader, description, responseHeader)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (StringUtils.isNotBlank(name) && name.length() >= 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口名称过长");
        }
        if (StringUtils.isNotBlank(url) && url.length() >= 1024) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口路径过长");
        }
        //请求方法是否合法
        if (StringUtils.isNotBlank(method)) {
            if (RequestMethod.valueOf(method.toUpperCase(Locale.ROOT)).toString() == null) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "非法的接口请求方式");
            }
        }
    }
}




