package com.idiotic.common.interceptor;

import com.idiotic.common.expection.CommonExpection;
import com.idiotic.common.utils.JwtToken;
import com.idiotic.common.utils.Result;
import com.idiotic.common.utils.ResultCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 自定义拦截器  继承  HandlerInterceptorAdapter
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {
    /**
     * preHandle  进入控制器之前执行的操作
     * 1  简化获取token数据的代码编写
     * 判断是否登录
     * 2  判断用户的权限
     */
    @Autowired
    private JwtToken jwtToken;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", request.getMethod());
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        response.setStatus(HttpStatus.OK.value());
        String token = request.getHeader("token");
        if (!StringUtils.isEmpty(token)){
            Claims claims = jwtToken.parseToken(token);
            if (claims != null){
                return true;
            }
        }
        return false;
    }

    /**
     * postHandle  执行控制器方法之后执行的操作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
    /**
     * afterCompletion  响应结束之前执行的操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
