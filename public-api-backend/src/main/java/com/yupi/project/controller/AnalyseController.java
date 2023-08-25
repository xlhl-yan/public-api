package com.yupi.project.controller;

import com.yupi.project.annotation.AuthCheck;
import com.yupi.project.common.BaseResponse;
import com.yupi.project.common.ResultUtils;
import com.yupi.project.constant.UserConstant;
import com.yupi.project.model.vo.InterfaceInfoVO;
import com.yupi.project.service.AnalyseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * AnalyseController
 *
 * @author xlhl
 * @version 1.0
 * @description 分析接口信息
 */
@RestController
@RequestMapping("/analyse")
@Slf4j
public class AnalyseController {

    @Resource
    private AnalyseService analyseService;

    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo(Integer top) {
        top = Optional.ofNullable(top).orElse(10);

        return ResultUtils.success(analyseService.listTopInvokeInterfaceInfo(top));
    }
}
