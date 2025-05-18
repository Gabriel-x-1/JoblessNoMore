package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.Experience;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.domain.UserProfile;
import com.example.mvcproducts.repositories.UserProfileRepository;
import com.example.mvcproducts.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    public ProfileServiceImpl(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfile getProfileById(Long userId) {
        return userRepository.findById(userId)
            .map(user -> userProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found")))
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserProfile updateExperience(List<Experience> experience) {
        UserProfile profile = getCurrentUserProfile();
        profile.setExperience(experience);
        return userProfileRepository.save(profile);
    }

    @Override
    public UserProfile updateEducation(List<String> education) {
        UserProfile profile = getCurrentUserProfile();
        profile.setEducation(education);
        return userProfileRepository.save(profile);
    }

    @Override
    public UserProfile updateSkills(List<String> skills) {
        UserProfile profile = getCurrentUserProfile();
        profile.setSkills(skills);
        return userProfileRepository.save(profile);
    }

    @Override
    public void deleteExperience(int index) {
        UserProfile profile = getCurrentUserProfile();
        List<Experience> experiences = new ArrayList<>(profile.getExperience());
        if (index >= 0 && index < experiences.size()) {
            experiences.remove(index);
            profile.setExperience(experiences);
            userProfileRepository.save(profile);
        }
    }

    @Override
    public void deleteEducation(int index) {
        UserProfile profile = getCurrentUserProfile();
        List<String> educations = new ArrayList<>(profile.getEducation());
        if (index >= 0 && index < educations.size()) {
            educations.remove(index);
            profile.setEducation(educations);
            userProfileRepository.save(profile);
        }
    }

    @Override
    public void deleteSkill(String skill) {
        UserProfile profile = getCurrentUserProfile();
        List<String> skills = new ArrayList<>(profile.getSkills());
        skills.remove(skill);
        profile.setSkills(skills);
        userProfileRepository.save(profile);
    }

    private UserProfile getCurrentUserProfile() {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userProfileRepository.findByUserId(currentUser.getId())
            .orElseThrow(() -> new RuntimeException("Profile not found"));
    }
}