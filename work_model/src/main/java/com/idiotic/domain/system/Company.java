package com.idiotic.domain.system;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Company {
    private Integer id;
    private String companyName;
    private String aboutSite;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "about_site")
    public String getAboutSite() {
        return aboutSite;
    }

    public void setAboutSite(String aboutSite) {
        this.aboutSite = aboutSite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id &&
                Objects.equals(companyName, company.companyName) &&
                Objects.equals(aboutSite, company.aboutSite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, aboutSite);
    }
}
