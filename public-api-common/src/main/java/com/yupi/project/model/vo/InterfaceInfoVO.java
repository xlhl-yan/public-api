package com.yupi.project.model.vo;

import com.yupi.project.model.entity.InterfaceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * InterfaceInfoVO
 *
 * @author xlhl
 * @version 1.0
 * @description 接口信息分析包装类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoVO extends InterfaceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 接口调用次数
     */
    private Integer totalNum;

}
