package com.newt.pojo.alibaba;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Description aliyun文件上传
 * @Author zcc
 * @Date 18/10/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OssAliyunField {
    @Value("oss.aliyun.first.accessKeyId")
    private String accessKeyId;

    @Value("oss.aliyun.first.accessKeySecret")
    private String accessKeySecret;

    @Value("oss.aliyun.first.bucketName")
    private String bucketName;

    @Value("oss.aliyun.first.endPoint")
    private String endPoint;

    @Value("oss.aliyun.first.styleName")
    private String styleName;

    @Value("oss.aliyun.first.prefix")
    private String prefix;
}
