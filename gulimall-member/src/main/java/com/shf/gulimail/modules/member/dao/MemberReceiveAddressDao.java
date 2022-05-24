package com.shf.gulimail.modules.member.dao;

import com.shf.gulimail.common.dao.BaseDao;
import com.shf.gulimail.modules.member.entity.MemberReceiveAddressEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员收货地址
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Mapper
public interface MemberReceiveAddressDao extends BaseDao<MemberReceiveAddressEntity> {
	
}