package com.example.mvcproducts.controllers;

import com.example.mvcproducts.dto.JobDTO;
import com.example.mvcproducts.services.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {
    private final JobService jobService;

    public HomeController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public String home(Model model) {
        Page<JobDTO> jobs = jobService.getAvailableJobs(PageRequest.of(0, 10));
        model.addAttribute("jobs", jobs.getContent());
        return "home";
    }

    @GetMapping("/api/jobs")
    @ResponseBody
    public Page<JobDTO> getJobs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return jobService.getAvailableJobs(PageRequest.of(page, size));
    }

    @PostMapping("/api/jobs/{id}/apply")
    @ResponseBody
    public void applyForJob(@PathVariable Long id) {
        jobService.applyForJob(id);
    }

    @PostMapping("/api/jobs/{id}/reject")
    @ResponseBody
    public void rejectJob(@PathVariable Long id) {
        jobService.rejectJob(id);
    }
}
