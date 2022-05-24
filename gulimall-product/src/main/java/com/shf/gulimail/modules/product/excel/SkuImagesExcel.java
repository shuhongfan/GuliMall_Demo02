package com.shf.gulimail.modules.product.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * sku图片
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class SkuImagesExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "sku_id")
    private Long skuId;
    @Excel(name = "图片地址")
    private String imgUrl;
    @Excel(name = "排序")
    private Integer imgSort;
    @Excel(name = "默认图[0 - 不是默认图，1 - 是默认图]")
    private Integer defaultImg;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}