package com.shf.gulimail.modules.order.dao;

import com.shf.gulimail.common.dao.BaseDao;
import com.shf.gulimail.modules.order.entity.OrderSettingEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Mapper
public interface OrderSettingDao extends BaseDao<OrderSettingEntity> {
	
}