package com.idiotic.service;

import com.idiotic.dao.UserDao;
import com.idiotic.domain.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User userLogin(String username, String password){
        User user = userDao.findByUsernameAndPassword(username,password);
        return user;
    }
}
