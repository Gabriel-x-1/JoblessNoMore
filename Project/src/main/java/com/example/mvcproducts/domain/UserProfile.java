package com.example.mvcproducts.domain;

import java.util.List;

public class UserProfile {
    private String name;
    private String email;
    private String phone;
    private String lastJob;
    private String location;
    private String about;
    private List<String> skills;
    private List<String> education;

    private List<Experience> experience;
    private SocialLinks social;

    public UserProfile(){}

    public UserProfile(String name, String email, String phone, String lastJob, String location, String about, List<Experience> experience, SocialLinks social) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.lastJob = lastJob;
        this.location = location;
        this.about = about;
        this.experience = experience;
        this.social = social;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastJob() {
        return lastJob;
    }

    public void setLastJob(String lastJob) {
        this.lastJob = lastJob;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public List<String> getEducation() {
        return education;
    }

    public void addEducation(String education) {
        this.education.add(education);
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    public void addExperience(Experience experience) {
        this.experience.add(experience);
    }

    public SocialLinks getSocial() {
        return social;
    }

    public void setSocial(SocialLinks social) {
        this.social = social;
    }
}
