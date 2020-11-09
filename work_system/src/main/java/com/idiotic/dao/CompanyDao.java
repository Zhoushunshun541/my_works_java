package com.idiotic.dao;

import com.idiotic.domain.system.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import sun.awt.SunHints;

import java.util.List;

public interface CompanyDao extends JpaRepository<Company,Long>, JpaSpecificationExecutor<Company> {

//    @Query(value="SELECT * FROM company WHERE id = (SELECT id FROM company limit ?2, ?2 * ?3) LIMIT ?3",nativeQuery=true)
    @Query(value="SELECT * FROM company WHERE company_name LIKE '%?1%' OR id >= (SELECT id FROM company limit ?2, ?2 * ?3) LIMIT ?3",nativeQuery=true)
    List<Company> findAllData(String search,Integer page,Integer pageSize);

    @Query(value = "SELECT COUNT(*) FROM company",nativeQuery=true)
    Integer getCount();

    Page<Company> findAll(Pageable pageable);
}
