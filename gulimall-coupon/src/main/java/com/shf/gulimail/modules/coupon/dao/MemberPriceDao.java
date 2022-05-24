package com.shf.gulimail.modules.coupon.dao;

import com.shf.gulimail.common.dao.BaseDao;
import com.shf.gulimail.modules.coupon.entity.MemberPriceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Mapper
public interface MemberPriceDao extends BaseDao<MemberPriceEntity> {
	
}