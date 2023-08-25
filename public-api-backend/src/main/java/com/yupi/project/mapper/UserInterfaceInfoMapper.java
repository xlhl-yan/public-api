package com.yupi.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yupi.project.model.entity.UserInterfaceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xlhl
 * @description 针对表【user_interface_info(用户调用接口)】的数据库操作Mapper
 * @createDate 2023-08-22 16:53:13
 * @Entity com.yupi.project.model.entity.UserInterfaceInfo
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    /*
        select interfaceInfoId,sum(totalNum) as totalNum from user_interface_info
        where user_interface_info.isDelete = 0
        group by interfaceInfoId order by totalNum desc limit {top}
    */
    /**
     * 返回 调用次数最高的接口 TOP n
     *
     * @param top n
     * @return 接口信息集合
     */
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(@Param("top") Integer top);
}




