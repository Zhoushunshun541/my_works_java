package com.idiotic.domain.system.dto;

import com.idiotic.domain.system.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    private long id;
    @NotEmpty(message="姓名不得为空")
    private String name;
    private String mobile;
    private String sex;
    @Email
    private String email;
    @NotNull(message = "生日日期不得为空")
    private long age;
    @NotEmpty(message="密码不得为空")
    private String password;
    @NotEmpty(message="用户名不得为空")
    private String username;
    private String job;
    private long companyId;
    private String companyName;

    public User getUser() {
        User user = new User();
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
