package com.shf.gulimail.modules.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;


/**
 * 品牌
 *
 * @author shuhongfan shuhongfan@foxmail.com
 * @since 1.0.0 2022-05-21
 */
@Data
@ApiModel(value = "品牌")
public class BrandDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "品牌id")
	private Long id;

	@NotEmpty
	@NotBlank(message = "请输入名称")
	@ApiModelProperty(value = "品牌名")
	private String name;

	@NotEmpty
	@URL(message = "logo必须是一个合法的url地址")
	@ApiModelProperty(value = "品牌logo地址")
	private String logo;

	@NotEmpty
	@ApiModelProperty(value = "介绍")
	private String descript;

	@NotEmpty
	@ApiModelProperty(value = "显示状态[0-不显示；1-显示]")
	private Integer showStatus;

	@Pattern(regexp = "/^[a-zA-Z]$/")
	@ApiModelProperty(value = "检索首字母")
	private String firstLetter;

	@Min(value = 0,message = "排序必须大于0")
	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "创建者")
	private Long creator;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;


}