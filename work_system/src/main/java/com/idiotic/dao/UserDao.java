package com.idiotic.dao;

import com.idiotic.domain.system.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findByUsernameAndPassword(String username,String password);
    User findByMobile(String mobile);
}
