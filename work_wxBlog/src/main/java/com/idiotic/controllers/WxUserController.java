package com.idiotic.controllers;


import com.idiotic.common.utils.Result;
import com.idiotic.common.utils.ResultCode;
import com.idiotic.domain.wx_blog.WxUser;
import com.idiotic.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/wx")
@RestController
public class WxUserController {

    @Autowired
    private WxUserService wxUserService;
    // 存储用户信息
    @RequestMapping(value = "/add_user",method = RequestMethod.POST)
    public Result saveUser(WxUser wxUser){
        WxUser user = wxUserService.findByOpenId(wxUser.getOpenId());
        if (user == null){
            wxUserService.addUser(wxUser);
        }
        return new Result(ResultCode.SUCCESS);
    }
}
