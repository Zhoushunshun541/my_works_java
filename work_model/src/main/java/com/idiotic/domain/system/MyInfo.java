package com.idiotic.domain.system;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "my_info", schema = "my_works", catalog = "")
public class MyInfo {
    private Integer id;
    private String skills;
    private String aboutMe;
    private String selfIntroduce;
    private Collection<User> usersById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return id == myInfo.id &&
                Objects.equals(skills, myInfo.skills) &&
                Objects.equals(aboutMe, myInfo.aboutMe) &&
                Objects.equals(selfIntroduce, myInfo.selfIntroduce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skills, aboutMe, selfIntroduce);
    }

    @OneToMany(mappedBy = "myInfoByInfoId")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
