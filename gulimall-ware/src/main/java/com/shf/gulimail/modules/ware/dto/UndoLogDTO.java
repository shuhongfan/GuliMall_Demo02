package com.shf.gulimail.modules.ware.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@ApiModel(value = "")
public class UndoLogDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "")
	private Long branchId;

	@ApiModelProperty(value = "")
	private String xid;

	@ApiModelProperty(value = "")
	private String context;

	@ApiModelProperty(value = "")
	private byte[] rollbackInfo;

	@ApiModelProperty(value = "")
	private Integer logStatus;

	@ApiModelProperty(value = "")
	private Date logCreated;

	@ApiModelProperty(value = "")
	private Date logModified;

	@ApiModelProperty(value = "")
	private String ext;

	@ApiModelProperty(value = "创建者")
	private Long creator;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;


}