package com.idiotic.dao;

import com.idiotic.domain.system.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompanyDao extends JpaRepository<Company,Long>, JpaSpecificationExecutor<Company> {
}
