package com.shf.gulimail.modules.coupon.dao;

import com.shf.gulimail.common.dao.BaseDao;
import com.shf.gulimail.modules.coupon.entity.CouponEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Mapper
public interface CouponDao extends BaseDao<CouponEntity> {
	
}