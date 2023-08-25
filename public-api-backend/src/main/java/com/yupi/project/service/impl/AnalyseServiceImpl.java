package com.yupi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.InterfaceInfoMapper;
import com.yupi.project.mapper.UserInterfaceInfoMapper;
import com.yupi.project.model.entity.InterfaceInfo;
import com.yupi.project.model.entity.UserInterfaceInfo;
import com.yupi.project.model.vo.InterfaceInfoVO;
import com.yupi.project.service.AnalyseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * AnalyseServiceImpl
 *
 * @author xlhl
 * @version 1.0
 * @description 分析接口信息
 */
@Service
public class AnalyseServiceImpl implements AnalyseService {
    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public List<InterfaceInfoVO> listTopInvokeInterfaceInfo(Integer top) {
        top = Optional.ofNullable(top).orElse(10);
        List<UserInterfaceInfo> userInterfaceInfos = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(top);
        Map<Long, List<UserInterfaceInfo>> interfaceInfoMap = userInterfaceInfos
                .stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        QueryWrapper<InterfaceInfo> wrapper = new QueryWrapper<>();
        wrapper.in("id", interfaceInfoMap.keySet());
        System.out.println("interfaceInfoMap = " + interfaceInfoMap);
        List<InterfaceInfo> interfaceInfos = interfaceInfoMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(interfaceInfos)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        System.out.println("interfaceInfos = " + interfaceInfos);
        return interfaceInfos.stream().map(interfaceInfo -> {
            InterfaceInfoVO infoVO = new InterfaceInfoVO();
            BeanUtils.copyProperties(interfaceInfo, infoVO);
            infoVO.setTotalNum(interfaceInfoMap.get(interfaceInfo.getId()).get(0).getTotalNum());
            return infoVO;
        }).collect(Collectors.toList());

    }
}
