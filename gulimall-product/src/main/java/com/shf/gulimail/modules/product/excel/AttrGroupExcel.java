package com.shf.gulimail.modules.product.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 属性分组
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class AttrGroupExcel {
    @Excel(name = "分组id")
    private Long id;
    @Excel(name = "组名")
    private String attrGroupName;
    @Excel(name = "排序")
    private Integer sort;
    @Excel(name = "描述")
    private String descript;
    @Excel(name = "组图标")
    private String icon;
    @Excel(name = "所属分类id")
    private Long catelogId;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}