package com.example.mvcproducts.domain;

import java.util.List;

public class JobPost {
    private String title;
    private String location;
    private String type; // Full-Time, Part-Time
    private String salary;
    private String level;
    private List<String> techStack;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<String> getTechStack() {
        return techStack;
    }

    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobPost(String title, String location, String type, String salary, String level, List<String> techStack, String description) {
        this.title = title;
        this.location = location;
        this.type = type;
        this.salary = salary;
        this.level = level;
        this.techStack = techStack;
        this.description = description;
    }

    public JobPost() {}
}

