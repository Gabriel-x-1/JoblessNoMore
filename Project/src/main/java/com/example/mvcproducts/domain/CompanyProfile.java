package com.example.mvcproducts.domain;

public class CompanyProfile {
    private String name;
    private String location;
    private String industry;
    private String founded;
    private String employees;
    private String about;
    private String website;

    private ContactInfo contact;
    private Leadership leadership;
    private SocialLinks social;

    public CompanyProfile() {}

    public CompanyProfile(String name, String location, String industry, String founded, String employees, String about, String website, ContactInfo contact) {
        this.name = name;
        this.location = location;
        this.industry = industry;
        this.founded = founded;
        this.employees = employees;
        this.about = about;
        this.website = website;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getIndustry() {
        return industry;
    }

    public String getFounded() {
        return founded;
    }

    public String getEmployees() {
        return employees;
    }

    public String getAbout() {
        return about;
    }

    public String getWebsite() {
        return website;
    }

    public ContactInfo getContact() {
        return contact;
    }

    public Leadership getLeadership() {
        return leadership;
    }

    public SocialLinks getSocial() {
        return social;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setContact(ContactInfo contact) {
        this.contact = contact;
    }

    public void setLeadership(Leadership leadership) {
        this.leadership = leadership;
    }

    public void setSocial(SocialLinks social) {
        this.social = social;
    }
}
