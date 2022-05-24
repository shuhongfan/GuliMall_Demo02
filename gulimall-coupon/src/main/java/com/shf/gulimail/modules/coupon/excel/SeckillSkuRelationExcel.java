package com.shf.gulimail.modules.coupon.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 秒杀活动商品关联
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class SeckillSkuRelationExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "活动id")
    private Long promotionId;
    @Excel(name = "活动场次id")
    private Long promotionSessionId;
    @Excel(name = "商品id")
    private Long skuId;
    @Excel(name = "秒杀价格")
    private BigDecimal seckillPrice;
    @Excel(name = "秒杀总量")
    private BigDecimal seckillCount;
    @Excel(name = "每人限购数量")
    private BigDecimal seckillLimit;
    @Excel(name = "排序")
    private Integer seckillSort;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}