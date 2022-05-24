package com.shf.gulimail.modules.product.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * spu信息介绍
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class SpuInfoDescExcel {
    @Excel(name = "商品id")
    private Long id;
    @Excel(name = "商品介绍")
    private String decript;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}