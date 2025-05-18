package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.JobApplication;
import java.util.List;

public interface DashboardService {
    List<JobApplication> getCompanyApplicants();
    List<JobApplication> getUserApplications();
    JobApplication updateApplicationStatus(Long applicationId, String status);
}
