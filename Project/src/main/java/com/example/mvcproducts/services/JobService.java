package com.example.mvcproducts.services;

import com.example.mvcproducts.dto.JobDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {
    Page<JobDTO> getAvailableJobs(Pageable pageable);
    void applyForJob(Long jobId);
    void rejectJob(Long jobId);
}
