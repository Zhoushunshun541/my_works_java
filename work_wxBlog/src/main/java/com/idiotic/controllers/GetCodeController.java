package com.idiotic.controllers;


import com.alibaba.fastjson.JSONObject;
import com.ctc.wstx.dtd.TokenModel;
import com.idiotic.common.utils.Result;
import com.idiotic.common.utils.ResultCode;
import com.idiotic.common.wechat.WxConfig;
import com.sun.jersey.core.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RequestMapping("/wx")
@RestController
public class GetCodeController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WxConfig wxConfig;

    @RequestMapping(value = "/get_openId",method = RequestMethod.POST)
    public Result getUserInfo(String code){
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appId}&secret={secret}&js_code={code}&grant_type=authorization_code";
        String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appId}&secret={secret}";
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appId", wxConfig.getAppId());
        requestMap.put("secret", wxConfig.getAppSecret());
        requestMap.put("code", code);
        // 获取open_id和session_key
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class,requestMap);
        // 获取access_token
        ResponseEntity<String> accessToken = restTemplate.getForEntity(tokenUrl, String.class,requestMap);
        JSONObject jsonObject= JSONObject.parseObject(responseEntity.getBody());
        JSONObject jsonToken= JSONObject.parseObject(accessToken.getBody());
        Map<String, String> data = new HashMap<>();
        data.put("open_id",jsonObject.getString("openid"));
        data.put("session_key",jsonObject.getString("session_key"));
        data.put("access_token",jsonToken.getString("access_token"));
        return new Result(ResultCode.SUCCESS,data);
    }

    @RequestMapping(value = "/get_user_mobile",method = RequestMethod.POST)
    public String getUserMobile(String encryptedData, String iv, String session_key) {
        byte[] encrypData = Base64.decode(encryptedData);
        byte[] ivData = Base64.decode(iv);
        byte[] sessionKey = Base64.decode(session_key);
        String str="";
        try {
            str = decrypt(sessionKey,ivData,encrypData);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(str);
        return str;
    }

    public static String decrypt(byte[] key, byte[] iv, byte[] encData) throws Exception {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        //解析解密后的字符串
        return new String(cipher.doFinal(encData),"UTF-8");
    }



}
