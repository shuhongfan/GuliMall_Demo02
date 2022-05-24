package com.shf.gulimail.modules.product.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 商品三级分类
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class CategoryExcel {
    @Excel(name = "分类id")
    private Long id;
    @Excel(name = "分类名称")
    private String name;
    @Excel(name = "父分类id")
    private Long parentCid;
    @Excel(name = "层级")
    private Integer catLevel;
    @Excel(name = "是否显示[0-不显示，1显示]")
    private Integer showStatus;
    @Excel(name = "排序")
    private Integer sort;
    @Excel(name = "图标地址")
    private String icon;
    @Excel(name = "计量单位")
    private String productUnit;
    @Excel(name = "商品数量")
    private Integer productCount;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}