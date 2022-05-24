package com.shf.gulimail.modules.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shf.gulimail.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 会员收藏的商品
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("ums_member_collect_spu")
public class MemberCollectSpuEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
	private Long memberId;
    /**
     * spu_id
     */
	private Long spuId;
    /**
     * spu_name
     */
	private String spuName;
    /**
     * spu_img
     */
	private String spuImg;
    /**
     * create_time
     */
	private Date createTime;
}