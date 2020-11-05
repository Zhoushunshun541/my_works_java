package com.idiotic.domain.system.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDto {
    @NotEmpty(message="用户名不得为空")
    private String username;
    @NotEmpty(message="密码不得为空")
    private String password;
}
