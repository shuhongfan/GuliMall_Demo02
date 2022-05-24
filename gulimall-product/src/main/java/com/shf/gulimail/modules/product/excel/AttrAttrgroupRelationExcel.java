package com.shf.gulimail.modules.product.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 属性&属性分组关联
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class AttrAttrgroupRelationExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "属性id")
    private Long attrId;
    @Excel(name = "属性分组id")
    private Long attrGroupId;
    @Excel(name = "属性组内排序")
    private Integer attrSort;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}