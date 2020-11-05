package com.idiotic.controller;


import com.idiotic.common.utils.IdWorker;
import com.idiotic.common.utils.JwtToken;
import com.idiotic.common.utils.Result;
import com.idiotic.common.utils.ResultCode;
import com.idiotic.domain.system.MyInfo;
import com.idiotic.domain.system.User;
import com.idiotic.domain.system.dto.LoginDto;
import com.idiotic.domain.system.dto.UserDto;
import com.idiotic.service.MyInfoService;
import com.idiotic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/sys")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MyInfoService myInfoService;
    @Autowired
    private JwtToken jwtToken;

    private Long timeStamp = new Date().getTime() / 1000;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result userLogin(@Validated LoginDto loginDto, BindingResult bindingResult){
        StringBuilder sb = new StringBuilder();
        if (bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError err : errors) {
                sb.append(err.getDefaultMessage()+";");
            }
            return new Result(400,sb.toString(),false);
        }
        User user = userService.userLogin(loginDto.getUsername(),loginDto.getPassword());
        userService.setUserTime(user,2);
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

    @RequestMapping(value = "/add_user",method = RequestMethod.POST)
    public Result addUser(@Validated UserDto userDto){
        System.out.println(userDto);
        User user = userDto.getUser();
        user.setCreateTime(timeStamp);
        userService.addUser(user);
        return new Result(ResultCode.SUCCESS);
    }
}
