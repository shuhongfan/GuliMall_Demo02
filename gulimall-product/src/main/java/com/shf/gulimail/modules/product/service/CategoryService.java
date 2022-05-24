package com.shf.gulimail.modules.product.service;

import com.shf.gulimail.modules.product.dto.CategoryDTO;
import com.shf.gulimail.modules.product.entity.CategoryEntity;
import com.shf.gulimail.common.service.CrudService;

import java.util.List;

/**
 * 商品三级分类
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
public interface CategoryService extends CrudService<CategoryEntity, CategoryDTO> {

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);
}