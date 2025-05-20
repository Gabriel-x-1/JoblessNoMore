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

import java.time.LocalDate;
import java.util.*;
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

    @GetMapping("/create-job")
    public String createJobPage(Model model) {
        model.addAttribute("job", new Job()); // empty Job object for form binding
        return "create-job";
    }


    @PostMapping("/jobs/create")
    public String createJobSubmit(
            @RequestParam String title,
            @RequestParam String location,
            @RequestParam String type,
            @RequestParam(required = false) String salary,
            @RequestParam String description,
            @RequestParam(required = false) String responsibilities,
            @RequestParam(required = false) String requirements,
            @RequestParam(required = false) String startDateStr,  // Get date as String
            Authentication authentication
    ) {
        User company = userService.findByEmail(authentication.getName());

        List<String> respList = responsibilities != null
                ? Arrays.stream(responsibilities.split(",")).map(String::trim).collect(Collectors.toList())
                : Collections.emptyList();

        List<String> reqList = requirements != null
                ? Arrays.stream(requirements.split(",")).map(String::trim).collect(Collectors.toList())
                : Collections.emptyList();

        LocalDate startDate = null;
        if (startDateStr != null && !startDateStr.isEmpty()) {
            startDate = LocalDate.parse(startDateStr);  // assumes yyyy-MM-dd format from input[type=date]
        }

        Job job = new Job(
                title,
                company.getUsername(),
                location,
                type,
                salary,
                description,
                respList,
                reqList,
                startDate,
                company
        );

        jobRepository.save(job);
        return "redirect:/company/dashboard";
    }





}
