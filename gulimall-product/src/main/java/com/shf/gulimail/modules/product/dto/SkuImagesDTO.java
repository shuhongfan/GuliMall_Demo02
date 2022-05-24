package com.shf.gulimail.modules.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * sku图片
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@ApiModel(value = "sku图片")
public class SkuImagesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "sku_id")
	private Long skuId;

	@ApiModelProperty(value = "图片地址")
	private String imgUrl;

	@ApiModelProperty(value = "排序")
	private Integer imgSort;

	@ApiModelProperty(value = "默认图[0 - 不是默认图，1 - 是默认图]")
	private Integer defaultImg;

	@ApiModelProperty(value = "创建者")
	private Long creator;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;


}