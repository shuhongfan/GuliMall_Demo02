package com.shf.gulimail.modules.order.service;

import com.shf.gulimail.common.service.CrudService;
import com.shf.gulimail.modules.order.dto.OrderItemDTO;
import com.shf.gulimail.modules.order.entity.OrderItemEntity;

/**
 * 订单项信息
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
public interface OrderItemService extends CrudService<OrderItemEntity, OrderItemDTO> {

}