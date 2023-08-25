package com.yupi.project.service.impl;

import com.yupi.project.model.vo.InterfaceInfoVO;
import com.yupi.project.service.AnalyseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AnalyseServiceImplTest {

    @Resource
    private AnalyseService analyseService;


    @Test
    void listTopInvokeInterfaceInfo() {
        List<InterfaceInfoVO> info = analyseService.listTopInvokeInterfaceInfo(10);

        System.out.println("info = " + info);
    }
}