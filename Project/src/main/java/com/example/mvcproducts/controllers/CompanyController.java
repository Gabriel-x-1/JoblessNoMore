package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Job;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.domain.UserJobInteraction;
import com.example.mvcproducts.dto.RegisterRequest;
import com.example.mvcproducts.repositories.JobRepository;
import com.example.mvcproducts.services.UserService;
import com.example.mvcproducts.services.UserJobInteractionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final UserService userService;
    private final JobRepository jobRepository;
    private final UserJobInteractionService userJobInteractionService;

    public CompanyController(UserService userService, 
                           JobRepository jobRepository,
                           UserJobInteractionService userJobInteractionService) {
        this.userService = userService;
        this.jobRepository = jobRepository;
        this.userJobInteractionService = userJobInteractionService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "company-login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        RegisterRequest request = new RegisterRequest();
        request.setRole("COMPANY");
        model.addAttribute("registerRequest", request);
        return "company-register";
    }

    @PostMapping("/register")
    public String registerCompany(RegisterRequest request) {
        request.setRole("COMPANY");
        userService.register(request);
        return "redirect:/company/login?registered";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        String companyEmail = authentication.getName();
        User company = userService.findByEmail(companyEmail);
        List<Job> companyJobs = jobRepository.findByCompanyUser(company);
        
        Map<Job, List<Map<String, String>>> jobApplications = new HashMap<>();
        for (Job job : companyJobs) {
            List<UserJobInteraction> applications = userJobInteractionService
                .findByJobIdAndInteractionType(job.getId(), "APPLIED");
                
            List<Map<String, String>> applicantDetails = applications.stream()
                .map(interaction -> {
                    Map<String, String> details = new HashMap<>();
                    User applicant = userService.findByEmail(interaction.getUserId());
                    details.put("username", applicant.getUsername());
                    details.put("status", interaction.getStatus());
                    return details;
                })
                .collect(Collectors.toList());
                
            jobApplications.put(job, applicantDetails);
        }
        
        model.addAttribute("jobApplications", jobApplications);
        return "company-dashboard";
    }
}
