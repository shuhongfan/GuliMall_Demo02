package com.shf.gulimail.modules.product.dao;

import com.shf.gulimail.common.dao.BaseDao;
import com.shf.gulimail.modules.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {
	
}