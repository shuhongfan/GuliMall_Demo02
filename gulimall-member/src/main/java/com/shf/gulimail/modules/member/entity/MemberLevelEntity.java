package com.shf.gulimail.modules.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shf.gulimail.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员等级
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("ums_member_level")
public class MemberLevelEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 等级名称
     */
	private String name;
    /**
     * 等级需要的成长值
     */
	private Integer growthPoint;
    /**
     * 是否为默认等级[0->不是；1->是]
     */
	private Integer defaultStatus;
    /**
     * 免运费标准
     */
	private BigDecimal freeFreightPoint;
    /**
     * 每次评价获取的成长值
     */
	private Integer commentGrowthPoint;
    /**
     * 是否有免邮特权
     */
	private Integer priviledgeFreeFreight;
    /**
     * 是否有会员价格特权
     */
	private Integer priviledgeMemberPrice;
    /**
     * 是否有生日特权
     */
	private Integer priviledgeBirthday;
    /**
     * 备注
     */
	private String note;
}