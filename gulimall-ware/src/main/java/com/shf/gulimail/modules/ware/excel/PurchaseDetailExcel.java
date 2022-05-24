package com.shf.gulimail.modules.ware.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class PurchaseDetailExcel {
    @Excel(name = "")
    private Long id;
    @Excel(name = "采购单id")
    private Long purchaseId;
    @Excel(name = "采购商品id")
    private Long skuId;
    @Excel(name = "采购数量")
    private Integer skuNum;
    @Excel(name = "采购金额")
    private BigDecimal skuPrice;
    @Excel(name = "仓库id")
    private Long wareId;
    @Excel(name = "状态[0新建，1已分配，2正在采购，3已完成，4采购失败]")
    private Integer status;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}