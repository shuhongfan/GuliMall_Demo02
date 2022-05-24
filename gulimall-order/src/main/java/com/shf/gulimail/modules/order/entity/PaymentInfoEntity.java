package com.shf.gulimail.modules.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shf.gulimail.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付信息表
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("oms_payment_info")
public class PaymentInfoEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 订单号（对外业务号）
     */
	private String orderSn;
    /**
     * 订单id
     */
	private Long orderId;
    /**
     * 支付宝交易流水号
     */
	private String alipayTradeNo;
    /**
     * 支付总金额
     */
	private BigDecimal totalAmount;
    /**
     * 交易内容
     */
	private String subject;
    /**
     * 支付状态
     */
	private String paymentStatus;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 确认时间
     */
	private Date confirmTime;
    /**
     * 回调内容
     */
	private String callbackContent;
    /**
     * 回调时间
     */
	private Date callbackTime;
}