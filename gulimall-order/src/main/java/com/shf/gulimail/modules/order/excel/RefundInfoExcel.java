package com.shf.gulimail.modules.order.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 退款信息
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
public class RefundInfoExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "退款的订单")
    private Long orderReturnId;
    @Excel(name = "退款金额")
    private BigDecimal refund;
    @Excel(name = "退款交易流水号")
    private String refundSn;
    @Excel(name = "退款状态")
    private Integer refundStatus;
    @Excel(name = "退款渠道[1-支付宝，2-微信，3-银联，4-汇款]")
    private Integer refundChannel;
    @Excel(name = "")
    private String refundContent;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}