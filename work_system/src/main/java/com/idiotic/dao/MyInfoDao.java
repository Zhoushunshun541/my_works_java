package com.idiotic.dao;

import com.idiotic.domain.system.MyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MyInfoDao extends JpaRepository<MyInfo,Integer>, JpaSpecificationExecutor<MyInfo> {
}
