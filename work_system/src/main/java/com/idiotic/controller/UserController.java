package com.idiotic.controller;


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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    private MyInfoService myInfoService;
    @Autowired
    private JwtToken jwtToken;

    private Long timeStamp = new Date().getTime() / 1000;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result userLogin(@Validated LoginDto loginDto, BindingResult bindingResult){
        // 自定义校验的报错
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
            String token = jwtToken.createToken(user.getId()+"", user.getName(), userMap);
            data.put("token",token);
            data.put("username",user.getUsername());
            data.put("pic",user.getPic());
            data.put("name",user.getName());
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
    public Result getInfo(HttpServletRequest request){
        long userId = Long.parseLong((String) request.getAttribute("userId"));
        MyInfo data = myInfoService.findById(userId);
        if (data == null){
            return new Result(ResultCode.EMPTYDATA);
        }else{
            return new Result(ResultCode.SUCCESS,data);
        }
    }

    // 注册
    @RequestMapping(value = "/registry",method = RequestMethod.POST)
    @ResponseBody
    public Result addUser(@Validated UserDto userDto){
        User user = userDto.getUser();
        User esitUser = userService.getUserByMob(user.getMobile());
        if (esitUser == null){
            user.setCreateTime(timeStamp);
            System.out.println(user.toString());
            userService.addUser(user);
            return new Result(ResultCode.SUCCESS);
        }else{
            return new Result(400,"手机号已存在",false);
        }
    }

    @RequestMapping(value = "/edit_company",method = RequestMethod.POST)
    public Result editCompany(long company_id,long user_id){
        User user = userService.editCompany(company_id,user_id);
        Map<String,String> map = new HashMap<>();
        map.put("company_id",user.getCompanyId() + "");
        map.put("company_name",user.getCompanyName());
        map.put("user_id",user.getCompanyName());
        return new Result(ResultCode.SUCCESS,map);
    }

    @RequestMapping(value = "/edit_user_info",method = RequestMethod.POST)
    public Result editCompany(Long user_id,String mobile,String job,String email,String name){
        User user = userService.findByUserId(user_id);
        user.setMobile(mobile);
        user.setJob(job);
        user.setEmail(email);
        user.setName(name);
        userService.addUser(user);
        return new Result(ResultCode.SUCCESS);
    }
}
