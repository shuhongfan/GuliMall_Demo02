package com.shf.gulimail.modules.product.dao;

import com.shf.gulimail.common.dao.BaseDao;
import com.shf.gulimail.modules.product.entity.AttrEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Mapper
public interface AttrDao extends BaseDao<AttrEntity> {
	
}