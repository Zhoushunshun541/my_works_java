package com.idiotic.domain.system;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "my_info", schema = "my_works")
public class MyInfo {
    private long id;
    private long userId;
    private String skills;
    private String aboutMe;
    private String selfIntroduce;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "skills")
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Basic
    @Column(name = "about_me")
    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Basic
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    @Basic
    @Column(name = "self_introduce")
    public String getSelfIntroduce() {
        return selfIntroduce;
    }

    public void setSelfIntroduce(String selfIntroduce) {
        this.selfIntroduce = selfIntroduce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyInfo myInfo = (MyInfo) o;
        return Objects.equals(id, myInfo.id) &&
                Objects.equals(skills, myInfo.skills) &&
                Objects.equals(aboutMe, myInfo.aboutMe) &&
                Objects.equals(selfIntroduce, myInfo.selfIntroduce);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, skills, aboutMe, selfIntroduce);
    }
}
