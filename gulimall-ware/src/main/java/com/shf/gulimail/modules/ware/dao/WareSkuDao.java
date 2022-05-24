package com.shf.gulimail.modules.ware.dao;

import com.shf.gulimail.common.dao.BaseDao;
import com.shf.gulimail.modules.ware.entity.WareSkuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Mapper
public interface WareSkuDao extends BaseDao<WareSkuEntity> {
	
}