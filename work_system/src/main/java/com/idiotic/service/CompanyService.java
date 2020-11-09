package com.idiotic.service;
import com.idiotic.dao.CompanyDao;
import com.idiotic.domain.system.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;

    public Page<Company> getAllCompany(Pageable pageable,String search){
        if (search == null){
            Page<Company> list = companyDao.findAll(pageable);
            return list;
        }else{
            List<Company> list = companyDao.findAllData(search, pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize());
            Long total = companyDao.getCount(search);
            Page<Company> pageList = new PageImpl(list, pageable, total);
            return pageList;
        }
    }
}
