package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.JobApplication;
import com.example.mvcproducts.services.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/company/applicants")
    public ResponseEntity<List<JobApplication>> getCompanyApplicants() {
        return ResponseEntity.ok(dashboardService.getCompanyApplicants());
    }

    @GetMapping("/applicant/applications")
    public ResponseEntity<List<JobApplication>> getUserApplications() {
        return ResponseEntity.ok(dashboardService.getUserApplications());
    }

    @PostMapping("/applications/{id}/status")
    public ResponseEntity<JobApplication> updateApplicationStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(dashboardService.updateApplicationStatus(id, status));
    }
}
