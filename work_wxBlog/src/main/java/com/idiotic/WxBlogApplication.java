package com.idiotic;


import com.idiotic.common.utils.JwtToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
//2 配置jpa注解扫描
@EntityScan(value = "com.idiotic.domain")
public class WxBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxBlogApplication.class,args);
    }

    @Bean
    public JwtToken jwtToken(){
        return new JwtToken();
    }
}
