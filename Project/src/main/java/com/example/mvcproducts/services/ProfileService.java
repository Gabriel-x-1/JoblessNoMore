package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.Experience;
import com.example.mvcproducts.domain.UserProfile;
import java.util.List;

public interface ProfileService {
    UserProfile getProfileById(Long userId);
    UserProfile updateExperience(List<Experience> experience);
    UserProfile updateEducation(List<String> education);
    UserProfile updateSkills(List<String> skills);
    void deleteExperience(int index);
    void deleteEducation(int index);
    void deleteSkill(String skill);
}
