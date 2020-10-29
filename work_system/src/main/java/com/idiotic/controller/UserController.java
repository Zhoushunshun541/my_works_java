package com.idiotic.controller;


import com.idiotic.common.utils.JwtToken;
import com.idiotic.common.utils.Result;
import com.idiotic.common.utils.ResultCode;
import com.idiotic.domain.system.User;
import com.idiotic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private JwtToken jwtToken;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result userLogin(String username,String password){
        User user = userService.userLogin(username,password);
        if (user != null){
            Map<String,Object> userMap = new HashMap<>();
            userMap.put("userData",user);
            String token = jwtToken.createToken(user.getId().toString(), user.getName(), userMap);
            userMap.put("token",token);
            return new Result(ResultCode.SUCCESS,userMap);
        }else{
            return new Result(ResultCode.NOTUSER);
        }
    }
}
