package com.shf.gulimail.modules.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shf.gulimail.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品会员价格
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sms_member_price")
public class MemberPriceEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * sku_id
     */
	private Long skuId;
    /**
     * 会员等级id
     */
	private Long memberLevelId;
    /**
     * 会员等级名
     */
	private String memberLevelName;
    /**
     * 会员对应价格
     */
	private BigDecimal memberPrice;
    /**
     * 可否叠加其他优惠[0-不可叠加优惠，1-可叠加]
     */
	private Integer addOther;
}