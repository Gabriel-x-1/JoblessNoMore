package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.Job;
import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    Job getJobById(String id);
    Job saveJob(Job job);
    void deleteJob(String id);
    List<Job> getJobsByCompany(String company);
}
