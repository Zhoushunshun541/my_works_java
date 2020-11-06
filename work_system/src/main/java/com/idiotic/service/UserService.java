package com.idiotic.service;

import com.idiotic.dao.UserDao;
import com.idiotic.domain.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    private Long timeStamp = new Date().getTime() / 1000;

    public User userLogin(String username, String password){
        User user = userDao.findByUsernameAndPassword(username,password);
        return user;
    }
    // 新增
    public void addUser(User user){
        User res = userDao.save(user);
        System.out.println(res);
    }
    // 设置时间
    public void setUserTime(User user,int type){
        switch (type){
            case 1:
                user.setEditTime(timeStamp);
                break;
            case 2:
                user.setLastLogin(timeStamp);
                break;
        }
        userDao.save(user);
    }
    // 设置时间
    public void setUserTime(User user,int type,int type1){
        if (type != type1){
            setUserTime(user,type);
            setUserTime(user,type1);
        }else{
            setUserTime(user,type);
        }
    }

    // 根据手机号查询是否已存在手机号
    public User getUserByMob(String mobile){
        return userDao.findByMobile(mobile);
    }
}
