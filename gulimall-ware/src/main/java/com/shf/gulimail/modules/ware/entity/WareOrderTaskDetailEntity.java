package com.shf.gulimail.modules.ware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shf.gulimail.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 库存工作单
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("wms_ware_order_task_detail")
public class WareOrderTaskDetailEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * sku_id
     */
	private Long skuId;
    /**
     * sku_name
     */
	private String skuName;
    /**
     * 购买个数
     */
	private Integer skuNum;
    /**
     * 工作单id
     */
	private Long taskId;
    /**
     * 仓库id
     */
	private Long wareId;
    /**
     * 1-已锁定  2-已解锁  3-扣减
     */
	private Integer lockStatus;
}