package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Job;
import com.example.mvcproducts.services.JobService;
import com.example.mvcproducts.services.UserJobInteractionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;
    private final UserJobInteractionService interactionService;

    public JobController(JobService jobService, UserJobInteractionService interactionService) {
        this.jobService = jobService;
        this.interactionService = interactionService;
    }

    @GetMapping
    public ResponseEntity<?> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJob(@PathVariable String id) {
        Job job = jobService.getJobById(id);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(job);
    }

    @PostMapping
    public ResponseEntity<?> createJob(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.saveJob(job));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable String id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{jobId}/interact")
    @ResponseBody
    public ResponseEntity<?> handleJobInteraction(
            @PathVariable String jobId,
            @RequestParam String action,
            Authentication authentication) {
        
        if (authentication == null) {
            return ResponseEntity.status(401).body("User not authenticated");
        }

        String userId = authentication.getName();
        interactionService.saveInteraction(userId, jobId, action);
        
        return ResponseEntity.ok().build();
    }

    @GetMapping("/applied")
    @ResponseBody
    public ResponseEntity<?> getAppliedJobs(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(401).build();
        }

        List<String> appliedJobIds = interactionService.getAppliedJobIds(authentication.getName());
        List<Job> appliedJobs = appliedJobIds.stream()
                .map(jobService::getJobById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(appliedJobs);
    }
}
