package com.idiotic.service;


import com.idiotic.common.utils.Result;
import com.idiotic.dao.SignUpDao;
import com.idiotic.domain.signUp.Happiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    @Autowired
    private SignUpDao signUpDao;
    public void signUp(Happiness happiness){
        signUpDao.save(happiness);
    }

    public Happiness findByMobile(String mobile){
        return signUpDao.findByMobile(mobile);
    }
}
