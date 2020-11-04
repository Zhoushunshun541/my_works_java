package com.idiotic.controller;


import com.idiotic.common.utils.JwtToken;
import com.idiotic.common.utils.Result;
import com.idiotic.common.utils.ResultCode;
import com.idiotic.domain.system.MyInfo;
import com.idiotic.domain.system.User;
import com.idiotic.service.MyInfoService;
import com.idiotic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/sys")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MyInfoService myInfoService;
    @Autowired
    private JwtToken jwtToken;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result userLogin(String username,String password){
        User user = userService.userLogin(username,password);
        System.out.println();
        if (user != null){
            Map<String,Object> userMap = new HashMap<>();
            Map<String,Object> data = new HashMap<>();
            userMap.put("userData",user);
            String token = jwtToken.createToken(user.getId().toString(), user.getName(), userMap);
            data.put("token",token);
            data.put("username",user.getName());
            data.put("user_id",user.getId());
            data.put("email",user.getEmail());
            data.put("mobile",user.getMobile());
            data.put("job",user.getJob());
            data.put("company_name",user.getCompanyName());
            data.put("company_id",user.getCompanyId());
            return new Result(ResultCode.SUCCESS,data);
        }else{
            return new Result(ResultCode.NOTUSER);
        }
    }

    // RequestMapping中的name是在jwt的接口中获取的
    @RequestMapping(value = "/get_info",method = RequestMethod.GET)
    public Result getInfo(Integer user_id){
        MyInfo data = myInfoService.findById(user_id);
        if (data == null){
            return new Result(ResultCode.FAIL);
        }else{
            return new Result(ResultCode.SUCCESS,data);
        }
    }
}
