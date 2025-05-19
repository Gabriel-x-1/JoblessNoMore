package com.example.mvcproducts.controllers;

import com.example.mvcproducts.services.UserJobInteractionService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final UserJobInteractionService interactionService;

    public DashboardController(UserJobInteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @GetMapping("/seeker/dashboard")
    public String userDashboard(Model model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }

        String userId = authentication.getName();
        model.addAttribute("appliedJobs", interactionService.getAppliedJobsWithDetails(userId));
        return "user-dashboard";
    }
}
