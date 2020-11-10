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

@CrossOrigin
@RestController
@RequestMapping("/sys")
public class MyInfoController {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MyInfoService myInfoService;

    @RequestMapping(value = "/edit_my_info",method = RequestMethod.POST)
    public Result editMyInfo(MyInfo myInfo){
        myInfoService.editInfo(myInfo);
        return new Result(ResultCode.SUCCESS);
    }
}
