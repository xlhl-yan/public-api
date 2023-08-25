package com.yupi.project.service;

import com.yupi.project.model.vo.InterfaceInfoVO;

import java.util.List;

/**
 * @author xlhl
 */
public interface AnalyseService {
    /**
     * 获取调用次数最高接口 top n，默认 top 10
     *
     * @param top n
     * @return
     */
    List<InterfaceInfoVO> listTopInvokeInterfaceInfo(Integer top);
}
