package com.idiotic.domain.wx_blog;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@IdClass(wXUserPK.class)
public class WxUser {
    private int id;
    private int openId;
    private String name;
    private String sex;
    private String mobile;
    private Integer age;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "openId")
    public int getOpenId() {
        return openId;
    }

    public void setOpenId(int openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WxUser wxUser = (WxUser) o;
        return id == wxUser.id &&
                openId == wxUser.openId &&
                Objects.equals(name, wxUser.name) &&
                Objects.equals(sex, wxUser.sex) &&
                Objects.equals(mobile, wxUser.mobile) &&
                Objects.equals(age, wxUser.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, openId, name, sex, mobile, age);
    }
}
