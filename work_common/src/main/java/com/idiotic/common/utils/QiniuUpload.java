package com.idiotic.common.utils;

import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "qiniu.config")
public class QiniuUpload {
    private String accessKey;
    private String secretKey;
    private String bucket;
    public String getToken(){
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }
}
