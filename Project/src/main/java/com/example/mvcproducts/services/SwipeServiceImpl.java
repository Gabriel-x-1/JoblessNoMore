package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.Job;
import com.example.mvcproducts.domain.JobApplication;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.domain.UserJobPreference;
import com.example.mvcproducts.dto.JobDTO;
import com.example.mvcproducts.repositories.JobRepository;
import com.example.mvcproducts.repositories.UserJobPreferenceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SwipeServiceImpl implements SwipeService {
    private final JobRepository jobRepository;
    private final UserJobPreferenceRepository preferenceRepository;

    public SwipeServiceImpl(JobRepository jobRepository, 
                          UserJobPreferenceRepository preferenceRepository) {
        this.jobRepository = jobRepository;
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public Page<JobDTO> getSwipeableJobs(Pageable pageable) {
        User currentUser = getCurrentUser();
        return jobRepository.findSwipeableJobs(currentUser.getId(), pageable)
                          .map(this::convertToDTO);
    }

    @Override
    public void likeJob(Long jobId) {
        savePreference(jobId, true);
    }

    @Override
    public void dislikeJob(Long jobId) {
        savePreference(jobId, false);
    }

    @Override
    public void applyForJob(Long jobId) {
        User currentUser = getCurrentUser();
        Job job = jobRepository.findById(jobId)
            .orElseThrow(() -> new RuntimeException("Job not found"));

        JobApplication application = new JobApplication();
        application.setJob(job);
        application.setApplicant(currentUser);
        application.setStatus("PENDING");
        application.setAppliedDate(LocalDateTime.now());

        // Save the application using JobApplicationRepository
    }

    private void savePreference(Long jobId, boolean liked) {
        User currentUser = getCurrentUser();
        UserJobPreference preference = new UserJobPreference();
        preference.setUser(currentUser);
        preference.setJobId(jobId);
        preference.setLiked(liked);
        preference.setCreatedAt(LocalDateTime.now());
        preferenceRepository.save(preference);
    }

    private User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    private JobDTO convertToDTO(Job job) {
        // Implement conversion logic
        JobDTO dto = new JobDTO();
        // ... set properties
        return dto;
    }
}
