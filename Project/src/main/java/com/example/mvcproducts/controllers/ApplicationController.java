package com.example.mvcproducts.controllers;

import com.example.mvcproducts.services.UserJobInteractionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final UserJobInteractionService userJobInteractionService;

    public ApplicationController(UserJobInteractionService userJobInteractionService) {
        this.userJobInteractionService = userJobInteractionService;
    }

    @PostMapping("/{jobId}/status")
    public ResponseEntity<?> updateStatus(
            @PathVariable String jobId,
            @RequestBody Map<String, String> request) {
        
        String userId = request.get("userId");
        String status = request.get("status");
        
        userJobInteractionService.updateApplicationStatus(jobId, userId, status);
        return ResponseEntity.ok().build();
    }
}
