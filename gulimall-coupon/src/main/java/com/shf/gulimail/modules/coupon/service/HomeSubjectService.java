package com.shf.gulimail.modules.coupon.service;

import com.shf.gulimail.common.service.CrudService;
import com.shf.gulimail.modules.coupon.dto.HomeSubjectDTO;
import com.shf.gulimail.modules.coupon.entity.HomeSubjectEntity;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
public interface HomeSubjectService extends CrudService<HomeSubjectEntity, HomeSubjectDTO> {

}