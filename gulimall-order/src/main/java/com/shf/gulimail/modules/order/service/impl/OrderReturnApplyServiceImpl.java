package com.shf.gulimail.modules.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shf.gulimail.common.service.impl.CrudServiceImpl;
import com.shf.gulimail.modules.order.dao.OrderReturnApplyDao;
import com.shf.gulimail.modules.order.dto.OrderReturnApplyDTO;
import com.shf.gulimail.modules.order.entity.OrderReturnApplyEntity;
import com.shf.gulimail.modules.order.service.OrderReturnApplyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Service
public class OrderReturnApplyServiceImpl extends CrudServiceImpl<OrderReturnApplyDao, OrderReturnApplyEntity, OrderReturnApplyDTO> implements OrderReturnApplyService {

    @Override
    public QueryWrapper<OrderReturnApplyEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<OrderReturnApplyEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}