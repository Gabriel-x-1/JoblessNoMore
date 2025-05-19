package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Job;
import com.example.mvcproducts.domain.UserJobInteraction;
import com.example.mvcproducts.services.JobService;
import com.example.mvcproducts.services.UserJobInteractionService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class DashboardController {
    private final UserJobInteractionService userJobInteractionService;
    private final JobService jobService;

    public DashboardController(UserJobInteractionService userJobInteractionService,
                             JobService jobService) {
        this.userJobInteractionService = userJobInteractionService;
        this.jobService = jobService;
    }

    @GetMapping("/seeker/dashboard")
    public String userDashboard(Model model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/seeker/login";
        }

        String userId = authentication.getName();
        List<UserJobInteraction> interactions = userJobInteractionService
            .findByUserIdAndInteractionType(userId, "APPLIED");

        List<Map<String, Object>> appliedJobs = interactions.stream()
            .map(interaction -> {
                Job job = jobService.getJobById(interaction.getJobId());
                Map<String, Object> jobDetails = new HashMap<>();
                jobDetails.put("title", job.getTitle());
                jobDetails.put("company", job.getCompany());
                jobDetails.put("location", job.getLocation());
                jobDetails.put("type", job.getType());
                jobDetails.put("salary", job.getSalary());
                jobDetails.put("description", job.getDescription());
                jobDetails.put("startDate", job.getStartDate());
                jobDetails.put("status", interaction.getStatus());
                return jobDetails;
            })
            .collect(Collectors.toList());

        model.addAttribute("appliedJobs", appliedJobs);
        return "user-dashboard";
    }
}
