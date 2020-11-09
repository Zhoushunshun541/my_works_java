package com.idiotic.service;

import com.idiotic.dao.CompanyDao;
import com.idiotic.dao.UserDao;
import com.idiotic.domain.system.Company;
import com.idiotic.domain.system.User;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CompanyDao companyDao;
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

    public User editCompany(long company_id,Long user_id){
            User user = userDao.findById(user_id).get();
            Company company = companyDao.findById(company_id).get();
            user.setCompanyName(company.getCompanyName());
            user.setCompanyId(company.getId());
            return userDao.saveAndFlush(user);
    }
}
