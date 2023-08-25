package com.yupi.project.mapper;

import com.yupi.project.model.entity.UserInterfaceInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class InterfaceInfoMapperTest {
    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Test
    void testList() {
        Integer top = 10;
        List<UserInterfaceInfo> userInterfaceInfos = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(top);
        assert userInterfaceInfos.size() != 0;
        System.out.println(userInterfaceInfos);
        Map<Long, List<UserInterfaceInfo>> collect = userInterfaceInfos.stream().collect(Collectors.groupingBy(UserInterfaceInfo::getId));

        System.out.println("collect = " + collect);
    }
}