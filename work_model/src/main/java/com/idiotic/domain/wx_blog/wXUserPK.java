package com.idiotic.domain.wx_blog;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
public class wXUserPK implements Serializable {
    private int id;
    private int openId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "openId")
    @Id
    public int getOpenId() {
        return openId;
    }

    public void setOpenId(int openId) {
        this.openId = openId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        wXUserPK wXUserPK = (wXUserPK) o;
        return id == wXUserPK.id &&
                openId == wXUserPK.openId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, openId);
    }
}
