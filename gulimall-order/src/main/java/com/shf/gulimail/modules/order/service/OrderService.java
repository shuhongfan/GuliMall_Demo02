package com.shf.gulimail.modules.order.service;

import com.shf.gulimail.common.service.CrudService;
import com.shf.gulimail.modules.order.dto.OrderDTO;
import com.shf.gulimail.modules.order.entity.OrderEntity;

/**
 * 订单
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
public interface OrderService extends CrudService<OrderEntity, OrderDTO> {

}