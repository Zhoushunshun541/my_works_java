package com.idiotic.controller;


import com.idiotic.common.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/info")
public class MyInfoController {

    @Autowired
    private IdWorker idWorker;

}
