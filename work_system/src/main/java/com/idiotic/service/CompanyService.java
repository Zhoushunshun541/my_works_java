package com.idiotic.service;
import com.idiotic.dao.CompanyDao;
import com.idiotic.domain.system.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;

    public Page<Company> getAllCompany(Pageable pageable,String search){
        
        if (search == null || search.trim() == ""){
            System.out.println(1);
            Page<Company> list = companyDao.findAll(pageable);
            return list;
        }else{
            System.out.println(2);
            List<Company> list = companyDao.findAllData(search.trim(), pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize());
            Long total = companyDao.getCount(search.trim());
            Page<Company> pageList = new PageImpl(list, pageable, total);
            return pageList;
        }
    }
}
