package com.tanphat.elca.entity;

public class Company {
    Integer id;
    String name;
    String foundationDate;
    Integer capital;
    String country;
    Boolean isHeadQuarter;

    public Company(Integer id, String name, String foundationDate, Integer capital, String country, Boolean isHeadQuarter) {
        this.id = id;
        this.name = name;
        this.foundationDate = foundationDate;
        this.capital = capital;
        this.country = country;
        this.isHeadQuarter = isHeadQuarter;
    }

    public Company() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", foundationDate=" + foundationDate + ", capital=" + capital + ", country="
                + country + ", isHeadQuarter=" + isHeadQuarter + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean isHeadQuarter() {
        return isHeadQuarter;
    }

    public void setHeadQuarter(Boolean headQuarter) {
        isHeadQuarter = headQuarter;
    }
}
