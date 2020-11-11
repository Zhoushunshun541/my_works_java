package com.idiotic.common.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "jwt.config")
public class JwtToken {
//    // 签名私钥
//    private String key = "idiotic";
//    // 签名失效时间
//    private Integer ttl = 3 * 24 * 60 * 60 * 100;
    // 签名私钥
    private String key;
    // 签名失效时间
    private Long ttl;

    /**
     * 设置认证的token
     * id 登录用户id
     * subject  登录用户名
     */
    public String createToken(String id, String name, Map<String, Object> map) {
        // 设置失效时间
        Long now = System.currentTimeMillis(); //当前毫秒数
        Long exp = now + ttl;
        //  根据map 创建claim
        JwtBuilder jwt = Jwts.builder().setClaims(map).setId(id).setSubject(name).signWith(SignatureAlgorithm.HS256, key);

        jwt.setExpiration(new Date(exp));
        return jwt.compact();
    }

    /**
     * 解析token
     */

    public Claims parseToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }
}
