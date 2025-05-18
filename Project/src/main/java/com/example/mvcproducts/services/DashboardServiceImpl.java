package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.JobApplication;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.repositories.JobApplicationRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {
    private final JobApplicationRepository jobApplicationRepository;

    public DashboardServiceImpl(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public List<JobApplication> getCompanyApplicants() {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return jobApplicationRepository.findByJob_CompanyUser(currentUser);
    }

    @Override
    public List<JobApplication> getUserApplications() {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return jobApplicationRepository.findByApplicant(currentUser);
    }

    @Override
    public JobApplication updateApplicationStatus(Long applicationId, String status) {
        JobApplication application = jobApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        application.setStatus(status);
        return jobApplicationRepository.save(application);
    }
}
