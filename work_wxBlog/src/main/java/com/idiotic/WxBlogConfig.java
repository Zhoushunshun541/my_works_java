package com.idiotic;

import com.idiotic.common.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 系统的全局配置
 */
@Configuration
public class WxBlogConfig extends WebMvcConfigurationSupport {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).
                addPathPatterns("/**").//2.指定拦截器的url地址
                excludePathPatterns("/sys/login").
                excludePathPatterns("/sys/registry");//3.指定不拦截的url地址
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                .allowedHeaders("*")
//                .allowCredentials(true)//是否允许证书 不再默认开启
                //设置允许的方法
                .allowedMethods("GET", "POST", "PUT", "DELETE","OPTION");
//                .maxAge(3600);//跨域允许时间
        super.addCorsMappings(registry);
    }
}
