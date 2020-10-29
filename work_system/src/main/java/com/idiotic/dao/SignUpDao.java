package com.idiotic.dao;

import com.idiotic.domain.signUp.Happiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SignUpDao extends JpaRepository<Happiness,String>, JpaSpecificationExecutor<Happiness> {
    public Happiness findByMobile(String mobile);
}
