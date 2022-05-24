package com.shf.gulimail.modules.ware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shf.gulimail.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购信息
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("wms_purchase")
public class PurchaseEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 
     */
	private Long assigneeId;
    /**
     * 
     */
	private String assigneeName;
    /**
     * 
     */
	private String phone;
    /**
     * 
     */
	private Integer priority;
    /**
     * 
     */
	private Integer status;
    /**
     * 
     */
	private Long wareId;
    /**
     * 
     */
	private BigDecimal amount;
    /**
     * 
     */
	private Date createTime;
    /**
     * 
     */
	private Date updateTime;
}