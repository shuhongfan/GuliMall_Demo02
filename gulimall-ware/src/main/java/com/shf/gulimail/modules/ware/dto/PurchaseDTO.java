package com.shf.gulimail.modules.ware.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 采购信息
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@ApiModel(value = "采购信息")
public class PurchaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "")
	private Long assigneeId;

	@ApiModelProperty(value = "")
	private String assigneeName;

	@ApiModelProperty(value = "")
	private String phone;

	@ApiModelProperty(value = "")
	private Integer priority;

	@ApiModelProperty(value = "")
	private Integer status;

	@ApiModelProperty(value = "")
	private Long wareId;

	@ApiModelProperty(value = "")
	private BigDecimal amount;

	@ApiModelProperty(value = "")
	private Date createTime;

	@ApiModelProperty(value = "")
	private Date updateTime;

	@ApiModelProperty(value = "创建者")
	private Long creator;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;


}