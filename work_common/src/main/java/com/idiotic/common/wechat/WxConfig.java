package com.idiotic.common.wechat;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "wechat")
public class WxConfig {
    private String appId;
    private String appSecret;
    // 发送消息的接口的访问凭证
    private String accessToken;

}
