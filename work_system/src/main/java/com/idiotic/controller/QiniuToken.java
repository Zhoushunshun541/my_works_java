package com.idiotic.controller;


import com.idiotic.common.utils.QiniuUpload;
import com.idiotic.common.utils.Result;
import com.idiotic.common.utils.ResultCode;
import com.idiotic.service.MyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/qiniu")
public class QiniuToken {
    @Autowired
    private QiniuUpload qiniuUpload;

    @RequestMapping(value="/get_token",method = RequestMethod.GET)
    public Result getQiniuToken(){
        String token = qiniuUpload.getToken();
        return new Result(ResultCode.SUCCESS,token);
    }
}
