package com.shf.gulimail.modules.member.dao;

import com.shf.gulimail.common.dao.BaseDao;
import com.shf.gulimail.modules.member.entity.MemberStatisticsInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员统计信息
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Mapper
public interface MemberStatisticsInfoDao extends BaseDao<MemberStatisticsInfoEntity> {
	
}