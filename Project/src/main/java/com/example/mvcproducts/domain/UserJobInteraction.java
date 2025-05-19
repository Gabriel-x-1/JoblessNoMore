package com.example.mvcproducts.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "user_job_interactions")
public class UserJobInteraction {
    @Id
    private String id;
    
    @Column(nullable = false)
    private String userId;
    
    @Column(nullable = false)
    private String jobId;
    
    @Column(nullable = false)
    private String interactionType;
    
    @Column(nullable = false)
    private long timestamp;

    @Column(nullable = false)
    private String status = "PENDING";

    // Required by JPA
    protected UserJobInteraction() {}

    public UserJobInteraction(String userId, String jobId, String interactionType) {
        this.id = java.util.UUID.randomUUID().toString();
        this.userId = userId;
        this.jobId = jobId;
        this.interactionType = interactionType;
        this.timestamp = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getJobId() {
        return jobId;
    }

    public String getInteractionType() {
        return interactionType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
