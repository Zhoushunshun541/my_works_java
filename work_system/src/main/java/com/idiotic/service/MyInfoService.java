package com.idiotic.service;


import com.idiotic.dao.MyInfoDao;
import com.idiotic.domain.system.MyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyInfoService {

    @Autowired
    private MyInfoDao myInfoDao;

    public MyInfo findById(Long id){
        MyInfo data = myInfoDao.findByUserId(id);
        return data;
    }

    public void editInfo(MyInfo myInfo){
        myInfoDao.save(myInfo);
    }
}
