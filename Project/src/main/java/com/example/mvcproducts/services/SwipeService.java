package com.example.mvcproducts.services;

import com.example.mvcproducts.dto.JobDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SwipeService {
    Page<JobDTO> getSwipeableJobs(Pageable pageable);
    void likeJob(Long jobId);
    void dislikeJob(Long jobId);
    void applyForJob(Long jobId);
}
