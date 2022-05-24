package com.shf.gulimail.modules.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shf.gulimail.modules.product.dao.CategoryDao;
import com.shf.gulimail.modules.product.dto.CategoryDTO;
import com.shf.gulimail.modules.product.entity.CategoryEntity;
import com.shf.gulimail.modules.product.service.CategoryService;
import com.shf.gulimail.common.service.impl.CrudServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 商品三级分类
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Service
public class CategoryServiceImpl extends CrudServiceImpl<CategoryDao, CategoryEntity, CategoryDTO> implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public QueryWrapper<CategoryEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public List<CategoryEntity> listWithTree() {
//        1.查出所有分类
        List<CategoryEntity> entities = baseDao.selectList(null);

//        2.组装成父子的树形结构
//        2.1 找到所有的一级分类
        List<CategoryEntity> level1Menu =
                entities
                        .stream()
                        .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                        .map(menu->{
                            menu.setChildren(getChildrens(menu,entities));
                            return menu;
                        })
                        .sorted((menu1,menu2)->(menu1.getSort()==null?0:menu1.getSort())-(menu2.getSort()==null?0:menu2.getSort()))
                        .collect(Collectors.toList());

        return level1Menu;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
//        检查当前删除的菜单，是否被别的地方引用

//        逻辑删除
        categoryDao.deleteBatchIds(asList);
    }

    /**
     * 递归查找所有菜单的子菜单
     * @param root
     * @param all
     * @return
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all){
        List<CategoryEntity> children = all.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == root.getId())
                .map(categoryEntity -> {
//                    1. 找到子菜单
                    categoryEntity.setChildren(getChildrens(categoryEntity, all));
                    return categoryEntity;
                })
//                2.菜单排序
                .sorted((menu1,menu2)->(menu1.getSort()==null?0:menu1.getSort())-(menu2.getSort()==null?0:menu2.getSort()))
                .collect(Collectors.toList());
        return children;
    }
}