package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.Job;
import com.example.mvcproducts.domain.JobApplication;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.dto.JobDTO;
import com.example.mvcproducts.repositories.JobApplicationRepository;
import com.example.mvcproducts.repositories.JobRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final JobApplicationRepository jobApplicationRepository;

    public JobServiceImpl(JobRepository jobRepository, JobApplicationRepository jobApplicationRepository) {
        this.jobRepository = jobRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public Page<JobDTO> getAvailableJobs(Pageable pageable) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return jobRepository.findAvailableJobsForUser(currentUser.getId(), pageable)
                .map(this::convertToDTO);
    }

    @Override
    public void applyForJob(Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        JobApplication application = new JobApplication();
        application.setJob(job);
        application.setApplicant(currentUser);
        application.setStatus("PENDING");
        application.setAppliedDate(LocalDateTime.now());

        jobApplicationRepository.save(application);
    }

    @Override
    public void rejectJob(Long jobId) {
        // Implement rejection logic if needed
    }

    private JobDTO convertToDTO(Job job) {
        JobDTO dto = new JobDTO();
        dto.setId(job.getId());
        dto.setTitle(job.getTitle());
        dto.setCompany(job.getCompany());
        dto.setLocation(job.getLocation());
        dto.setType(job.getType());
        dto.setSalary(job.getSalary());
        dto.setDescription(job.getDescription());
        dto.setRequirements(job.getRequirements());
        dto.setResponsibilities(job.getResponsibilities());
        dto.setStartDate(job.getStartDate());
        return dto;
    }
}
