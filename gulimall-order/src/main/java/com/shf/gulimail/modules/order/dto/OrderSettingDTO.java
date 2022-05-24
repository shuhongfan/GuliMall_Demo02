package com.shf.gulimail.modules.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 订单配置信息
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@ApiModel(value = "订单配置信息")
public class OrderSettingDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "秒杀订单超时关闭时间(分)")
	private Integer flashOrderOvertime;

	@ApiModelProperty(value = "正常订单超时时间(分)")
	private Integer normalOrderOvertime;

	@ApiModelProperty(value = "发货后自动确认收货时间（天）")
	private Integer confirmOvertime;

	@ApiModelProperty(value = "自动完成交易时间，不能申请退货（天）")
	private Integer finishOvertime;

	@ApiModelProperty(value = "订单完成后自动好评时间（天）")
	private Integer commentOvertime;

	@ApiModelProperty(value = "会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】")
	private Integer memberLevel;

	@ApiModelProperty(value = "创建者")
	private Long creator;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;


}