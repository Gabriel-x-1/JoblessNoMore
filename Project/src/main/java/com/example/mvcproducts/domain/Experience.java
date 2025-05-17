package com.example.mvcproducts.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String role;
    
    @Column(nullable = false)
    private String company;
    
    private String period;
    
    @Column(columnDefinition = "TEXT")
    private String description;

    public Experience(){}

    public Experience(String role, String company, String period, String description) {
        this.role = role;
        this.company = company;
        this.period = period;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
