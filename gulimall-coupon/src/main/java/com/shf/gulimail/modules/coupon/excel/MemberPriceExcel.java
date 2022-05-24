package com.shf.gulimail.modules.coupon.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品会员价格
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class MemberPriceExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "sku_id")
    private Long skuId;
    @Excel(name = "会员等级id")
    private Long memberLevelId;
    @Excel(name = "会员等级名")
    private String memberLevelName;
    @Excel(name = "会员对应价格")
    private BigDecimal memberPrice;
    @Excel(name = "可否叠加其他优惠[0-不可叠加优惠，1-可叠加]")
    private Integer addOther;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}