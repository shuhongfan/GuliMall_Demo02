package com.shf.gulimail.modules.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shf.gulimail.common.service.impl.CrudServiceImpl;
import com.shf.gulimail.modules.ware.dao.WareSkuDao;
import com.shf.gulimail.modules.ware.dto.WareSkuDTO;
import com.shf.gulimail.modules.ware.entity.WareSkuEntity;
import com.shf.gulimail.modules.ware.service.WareSkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * εεεΊε­
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Service
public class WareSkuServiceImpl extends CrudServiceImpl<WareSkuDao, WareSkuEntity, WareSkuDTO> implements WareSkuService {

    @Override
    public QueryWrapper<WareSkuEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<WareSkuEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}