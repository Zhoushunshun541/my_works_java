package com.idiotic.domain.system;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "my_info", schema = "my_works", catalog = "")
public class MyInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String skills;
    private String aboutMe;
    private String selfIntroduce;
    private Integer userId;
}
