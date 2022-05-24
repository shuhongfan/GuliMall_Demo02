package com.shf.gulimail.modules.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shf.gulimail.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 会员
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("ums_member")
public class MemberEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 会员等级id
     */
	private Long levelId;
    /**
     * 用户名
     */
	private String username;
    /**
     * 密码
     */
	private String password;
    /**
     * 昵称
     */
	private String nickname;
    /**
     * 手机号码
     */
	private String mobile;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 头像
     */
	private String header;
    /**
     * 性别
     */
	private Integer gender;
    /**
     * 生日
     */
	private Date birth;
    /**
     * 所在城市
     */
	private String city;
    /**
     * 职业
     */
	private String job;
    /**
     * 个性签名
     */
	private String sign;
    /**
     * 用户来源
     */
	private Integer sourceType;
    /**
     * 积分
     */
	private Integer integration;
    /**
     * 成长值
     */
	private Integer growth;
    /**
     * 启用状态
     */
	private Integer status;
    /**
     * 注册时间
     */
	private Date createTime;
}