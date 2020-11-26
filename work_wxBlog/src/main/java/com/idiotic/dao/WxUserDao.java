package com.idiotic.dao;

import com.idiotic.domain.wx_blog.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WxUserDao extends JpaRepository<WxUser, Long>, JpaSpecificationExecutor<WxUserDao> {
    public WxUser findByOpenId(String openId);
}
