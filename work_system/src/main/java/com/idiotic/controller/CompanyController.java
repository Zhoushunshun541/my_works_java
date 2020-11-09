package com.idiotic.controller;


import com.idiotic.common.utils.PageResult;
import com.idiotic.common.utils.Result;
import com.idiotic.common.utils.ResultCode;
import com.idiotic.domain.system.Company;
import com.idiotic.domain.system.dto.SearchDto;
import com.idiotic.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // 获取全部列表   包含分页数据
    @RequestMapping(value = "/get_all_list",method = RequestMethod.GET)
    public Result getAllCompany(@Validated SearchDto searchDto){
        // 这里的"id"是实体类的主键，记住一定要是实体类的属性，而不能是数据库的字段
        // 新建一个排序
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        //创建一个Pageable对象
        Pageable pageable = PageRequest.of(searchDto.getPage() - 1, searchDto.getPageSize(), sort);
        Page<Company> data = companyService.getAllCompany(pageable,searchDto.getSearch());
        PageResult<Company> pr = new PageResult(data.getTotalElements(),data.getContent());
        return new Result(ResultCode.SUCCESS,pr);
    }
}
