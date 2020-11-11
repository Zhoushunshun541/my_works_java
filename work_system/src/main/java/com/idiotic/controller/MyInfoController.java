package com.idiotic.controller;


import com.idiotic.common.utils.IdWorker;
import com.idiotic.common.utils.Result;
import com.idiotic.common.utils.ResultCode;
import com.idiotic.domain.system.MyInfo;
import com.idiotic.service.MyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/sys")
public class MyInfoController {

    @Autowired
    private MyInfoService myInfoService;

    @RequestMapping(value = "/edit_my_info",method = RequestMethod.POST)
    public Result editMyInfo(MyInfo myInfo, HttpServletRequest request){
        Long userId = Long.parseLong((String) request.getAttribute("userId"));
        MyInfo is_add = myInfoService.findById(userId);
        myInfo.setUserId(userId);
        if (is_add != null){
            myInfo.setId(is_add.getId());
        }
        myInfoService.editInfo(myInfo);

        return new Result(ResultCode.SUCCESS);
    }
}
