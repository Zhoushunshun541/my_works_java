package com.idiotic.domain.system.dto;

import com.idiotic.domain.system.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {
    private Integer id;
    @NotEmpty(message="姓名不得为空")
    private String name;
    private String mobile;
    private String sex;
    @Email
    private String email;
    private Integer age;
    @NotEmpty(message="密码不得为空")
    private String password;
    @NotEmpty(message="用户名不得为空")
    private String username;
    private String job;
    private Integer companyId;
    private String companyName;
    private User user;

    public User getUser() {
        user.setName(this.name);
        user.setMobile(this.mobile);
        user.setSex(this.sex);
        user.setEmail(this.email);
        user.setAge(this.age);
        user.setPassword(this.password);
        user.setUsername(this.username);
        user.setJob(this.job);
        user.setCompanyId(this.companyId);
        user.setCompanyName(this.companyName);
        return user;
    }

}
