package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.UserJobInteraction;
import com.example.mvcproducts.domain.Job;
import com.example.mvcproducts.repositories.UserJobInteractionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserJobInteractionService {
    private final UserJobInteractionRepository interactionRepository;
    private final JobService jobService;

    public UserJobInteractionService(UserJobInteractionRepository interactionRepository, JobService jobService) {
        this.interactionRepository = interactionRepository;
        this.jobService = jobService;
    }

    public void saveInteraction(String userId, String jobId, String interactionType) {
        UserJobInteraction interaction = new UserJobInteraction(userId, jobId, interactionType);
        interactionRepository.save(interaction);
    }

    public List<String> getAppliedJobIds(String userId) {
        return interactionRepository.findByUserIdAndInteractionType(userId, "APPLIED")
                .stream()
                .map(UserJobInteraction::getJobId)
                .collect(Collectors.toList());
    }

    public List<Job> getAppliedJobsWithDetails(String userId) {
        List<UserJobInteraction> interactions = interactionRepository
            .findByUserIdAndInteractionType(userId, "APPLIED");
        
        return interactions.stream()
            .map(interaction -> jobService.getJobById(interaction.getJobId()))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    public List<UserJobInteraction> findByJobIdAndInteractionType(String jobId, String interactionType) {
        return interactionRepository.findByJobIdAndInteractionType(jobId, interactionType);
    }

    public void updateApplicationStatus(String jobId, String userId, String status) {
        List<UserJobInteraction> applications = interactionRepository
            .findByJobIdAndUserIdAndInteractionType(jobId, userId, "APPLIED");
            
        if (!applications.isEmpty()) {
            UserJobInteraction application = applications.get(0);
            application.setStatus(status);
            interactionRepository.save(application);
        }
    }

    public List<UserJobInteraction> findByUserIdAndInteractionType(String userId, String interactionType) {
        return interactionRepository.findByUserIdAndInteractionType(userId, interactionType);
    }
}
