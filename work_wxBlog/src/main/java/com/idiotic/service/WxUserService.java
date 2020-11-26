package com.idiotic.service;


import com.idiotic.dao.WxUserDao;
import com.idiotic.domain.wx_blog.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxUserService {
    
    @Autowired
    private WxUserDao wxUserDao;
    public void addUser(WxUser wxUser){
        wxUserDao.save(wxUser);
    }

    public WxUser findByOpenId(String openId){
        return wxUserDao.findByOpenId(openId);
    }
}
