package com.shf.gulimail.modules.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shf.gulimail.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 秒杀活动场次
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sms_seckill_session")
public class SeckillSessionEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 场次名称
     */
	private String name;
    /**
     * 每日开始时间
     */
	private Date startTime;
    /**
     * 每日结束时间
     */
	private Date endTime;
    /**
     * 启用状态
     */
	private Integer status;
    /**
     * 创建时间
     */
	private Date createTime;
}