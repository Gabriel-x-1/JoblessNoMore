package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Experience;
import com.example.mvcproducts.domain.UserProfile;
import com.example.mvcproducts.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/view/{userId}")
    public ResponseEntity<UserProfile> viewProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(profileService.getProfileById(userId));
    }

    @PutMapping("/experience")
    public ResponseEntity<UserProfile> updateExperience(@RequestBody List<Experience> experience) {
        UserProfile profile = profileService.updateExperience(experience);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/education")
    public ResponseEntity<UserProfile> updateEducation(@RequestBody List<String> education) {
        UserProfile profile = profileService.updateEducation(education);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/skills")
    public ResponseEntity<UserProfile> updateSkills(@RequestBody List<String> skills) {
        UserProfile profile = profileService.updateSkills(skills);
        return ResponseEntity.ok(profile);
    }

    @DeleteMapping("/experience/{index}")
    public ResponseEntity<Void> deleteExperience(@PathVariable int index) {
        profileService.deleteExperience(index);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/education/{index}")
    public ResponseEntity<Void> deleteEducation(@PathVariable int index) {
        profileService.deleteEducation(index);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/skills/{skill}")
    public ResponseEntity<Void> deleteSkill(@PathVariable String skill) {
        profileService.deleteSkill(skill);
        return ResponseEntity.ok().build();
    }
}