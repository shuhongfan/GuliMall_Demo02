package com.shf.gulimail.modules.member.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 会员收藏的专题活动
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class MemberCollectSubjectExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "subject_id")
    private Long subjectId;
    @Excel(name = "subject_name")
    private String subjectName;
    @Excel(name = "subject_img")
    private String subjectImg;
    @Excel(name = "活动url")
    private String subjectUrll;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}