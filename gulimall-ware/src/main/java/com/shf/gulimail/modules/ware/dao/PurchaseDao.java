package com.shf.gulimail.modules.ware.dao;

import com.shf.gulimail.common.dao.BaseDao;
import com.shf.gulimail.modules.ware.entity.PurchaseEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Mapper
public interface PurchaseDao extends BaseDao<PurchaseEntity> {
	
}