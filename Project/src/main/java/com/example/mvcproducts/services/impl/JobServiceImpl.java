package com.example.mvcproducts.services.impl;

import com.example.mvcproducts.domain.Job;
import com.example.mvcproducts.repositories.JobRepository;
import com.example.mvcproducts.services.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(String id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public void deleteJob(String id) {
        jobRepository.deleteById(id);
    }

    @Override
    public List<Job> getJobsByCompany(String company) {
        return jobRepository.findByCompany(company);
    }
}
