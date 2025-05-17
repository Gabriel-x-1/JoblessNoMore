package com.example.mvcproducts.controllers;

import com.example.mvcproducts.dto.JobDTO;
import com.example.mvcproducts.services.SwipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/swipe")
public class SwipeController {
    private final SwipeService swipeService;

    public SwipeController(SwipeService swipeService) {
        this.swipeService = swipeService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<Page<JobDTO>> getSwipeableJobs(Pageable pageable) {
        return ResponseEntity.ok(swipeService.getSwipeableJobs(pageable));
    }

    @PostMapping("/{jobId}/like")
    public ResponseEntity<Void> likeJob(@PathVariable Long jobId) {
        swipeService.likeJob(jobId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{jobId}/dislike")
    public ResponseEntity<Void> dislikeJob(@PathVariable Long jobId) {
        swipeService.dislikeJob(jobId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{jobId}/apply")
    public ResponseEntity<Void> applyForJob(@PathVariable Long jobId) {
        swipeService.applyForJob(jobId);
        return ResponseEntity.ok().build();
    }
}
