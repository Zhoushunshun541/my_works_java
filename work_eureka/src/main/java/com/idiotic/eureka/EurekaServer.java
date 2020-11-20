package com.idiotic.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务端启动类
 */

@SpringBootApplication
@EnableEurekaServer // eureka  服务端配置
public class EurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class,args);
    }
}
