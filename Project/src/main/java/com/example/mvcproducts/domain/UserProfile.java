package com.example.mvcproducts.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private String email;
    private String phone;
    private String lastJob;
    private String location;
    
    @Column(columnDefinition = "TEXT")
    private String about;
    
    @ElementCollection
    @CollectionTable(name = "user_skills", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "skill")
    private List<String> skills;
    
    @ElementCollection
    @CollectionTable(name = "user_education", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "education")
    private List<String> education;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_id")
    private List<Experience> experience;

    @Embedded
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
