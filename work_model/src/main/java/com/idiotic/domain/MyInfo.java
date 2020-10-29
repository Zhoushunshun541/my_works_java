package com.idiotic.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "my_info", schema = "my_works", catalog = "")
public class MyInfo {
    private int id;
    private String title;
    private String content;
    private String bigCont;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "big_cont")
    public String getBigCont() {
        return bigCont;
    }

    public void setBigCont(String bigCont) {
        this.bigCont = bigCont;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyInfo myInfo = (MyInfo) o;
        return id == myInfo.id &&
                Objects.equals(title, myInfo.title) &&
                Objects.equals(content, myInfo.content) &&
                Objects.equals(bigCont, myInfo.bigCont);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, bigCont);
    }
}
