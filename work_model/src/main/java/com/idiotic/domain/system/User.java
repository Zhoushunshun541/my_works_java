package com.idiotic.domain.system;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String mobile;
    private String sex;
    private String email;
    private Integer age;
    private String password;
    private String username;
    private String job;
    private Integer companyId;
    private String companyName;
}
