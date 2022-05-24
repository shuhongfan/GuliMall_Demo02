package com.shf.gulimail.modules.product.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * sku销售属性&值
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class SkuSaleAttrValueExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "sku_id")
    private Long skuId;
    @Excel(name = "attr_id")
    private Long attrId;
    @Excel(name = "销售属性名")
    private String attrName;
    @Excel(name = "销售属性值")
    private String attrValue;
    @Excel(name = "顺序")
    private Integer attrSort;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}