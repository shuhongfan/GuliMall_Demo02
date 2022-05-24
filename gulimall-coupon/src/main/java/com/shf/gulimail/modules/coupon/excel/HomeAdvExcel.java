package com.shf.gulimail.modules.coupon.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 首页轮播广告
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class HomeAdvExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "名字")
    private String name;
    @Excel(name = "图片地址")
    private String pic;
    @Excel(name = "开始时间")
    private Date startTime;
    @Excel(name = "结束时间")
    private Date endTime;
    @Excel(name = "状态")
    private Integer status;
    @Excel(name = "点击数")
    private Integer clickCount;
    @Excel(name = "广告详情连接地址")
    private String url;
    @Excel(name = "备注")
    private String note;
    @Excel(name = "排序")
    private Integer sort;
    @Excel(name = "发布者")
    private Long publisherId;
    @Excel(name = "审核者")
    private Long authId;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}