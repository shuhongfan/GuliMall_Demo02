package com.shf.gulimail.modules.third_party.vo;


import lombok.Data;

import java.io.Serializable;

/**
 * 获取Token返回结果
 */
@Data
public class StsTokenVO implements Serializable {
    /**
     * 访问密钥标识
     */
    private String accessKeyId;
    /**
     * 访问密钥
     */
    private String accessKeySecret;
    /**
     * 安全令牌
     */
    private String securityToken;
}