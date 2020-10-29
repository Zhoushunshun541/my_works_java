package com.idiotic.controller;


import com.idiotic.common.utils.IdWorker;
import com.idiotic.common.utils.JwtToken;
import com.idiotic.common.utils.Result;
import com.idiotic.common.utils.ResultCode;
import com.idiotic.domain.signUp.Happiness;
import com.idiotic.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.dc.pr.PRError;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/sign_up")

public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(Happiness happiness){
        String mobile = happiness.getMobile();
        Happiness user = signUpService.findByMobile(mobile);
        if (user == null){
            IdWorker idWorker = new IdWorker();
            long id = idWorker.nextId();
            happiness.setId(id);
            happiness.setSign_time(new Date());
            signUpService.signUp(happiness);
            return new Result(ResultCode.SUCCESS);
        }else{
            return new Result(ResultCode.FAIL);
        }
    }

}
