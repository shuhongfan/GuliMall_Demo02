package com.shf.gulimail.modules.third_party.controller;


import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.shf.gulimail.common.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;

@RestController
public class OssController {

    private static final String OSS_ENDPOINT = "oss-cn-guangzhou.aliyuncs.com";
    private static final String ACCESS_KEY_ID = "LTAI5tBpuKeBykMF3j88TZWX";
    private static final String ACCESS_KEY_SECRET = "Er6qd8FQkSL9MWnSnBCV4jZ7h9bxHK";
    private static final String BUCKET_NAME = "gulimall-shf";

    @RequestMapping("/oss/policy")
    public Result policy(){
        OSS ossClient=new OSSClientBuilder().build(OSS_ENDPOINT,ACCESS_KEY_ID,ACCESS_KEY_SECRET);
        // host的格式为 bucketname.endpoint
        String host = "https://"+ BUCKET_NAME+ "."+OSS_ENDPOINT;
        // callbackUrl为 上传回调服务器的URL，请将下面的IP和Port配置为您自己的真实信息。
        // String callbackUrl = "http://88.88.88.88:8888";
        // 每一天产生一个文件夹
        // 用户上传文件时指定的前缀,如果是 / 则自动检测为文件夹。
        String dir = LocalDate.now().toString() + "/";

        JSONObject jsonObject = new JSONObject();
        //过期时间 100 秒
        long expireTime = 100;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);

        jsonObject.put("OSSAccessKeyId", ACCESS_KEY_ID);
        jsonObject.put("policy", encodedPolicy);
        jsonObject.put("signature", postSignature);
        jsonObject.put("dir", dir);
        jsonObject.put("host", host);
        jsonObject.put("expire", String.valueOf(expireEndTime / 1000));
        return new Result().ok(jsonObject);
    }


}
