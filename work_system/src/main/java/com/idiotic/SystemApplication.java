package com.idiotic;


import com.idiotic.common.utils.IdWorker;
import com.idiotic.common.utils.JwtToken;
import com.idiotic.common.utils.QiniuUpload;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

// 配置springboot扫描
@SpringBootApplication(scanBasePackages = "com.idiotic")
//2 配置jpa注解扫描
@EntityScan(value = "com.idiotic.domain")
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class);
    }
    @Bean
    public JwtToken jwtToken(){
        return new JwtToken();
    }

    @Bean
    public QiniuUpload qiniuUpload(){
        return new QiniuUpload();
    }
    //  解决no session
    @Bean
    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter(){
        return new OpenEntityManagerInViewFilter();
    }
}
