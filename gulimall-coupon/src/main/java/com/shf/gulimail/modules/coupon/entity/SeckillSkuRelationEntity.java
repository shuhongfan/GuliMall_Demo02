package com.shf.gulimail.modules.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shf.gulimail.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 秒杀活动商品关联
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sms_seckill_sku_relation")
public class SeckillSkuRelationEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
	private Long promotionId;
    /**
     * 活动场次id
     */
	private Long promotionSessionId;
    /**
     * 商品id
     */
	private Long skuId;
    /**
     * 秒杀价格
     */
	private BigDecimal seckillPrice;
    /**
     * 秒杀总量
     */
	private BigDecimal seckillCount;
    /**
     * 每人限购数量
     */
	private BigDecimal seckillLimit;
    /**
     * 排序
     */
	private Integer seckillSort;
}