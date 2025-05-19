package com.example.mvcproducts.repositories;

import com.example.mvcproducts.domain.UserJobInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserJobInteractionRepository extends JpaRepository<UserJobInteraction, String> {
    List<UserJobInteraction> findByUserIdAndInteractionType(String userId, String interactionType);
    List<UserJobInteraction> findByUserId(String userId);
    List<UserJobInteraction> findByJobIdAndInteractionType(String jobId, String interactionType);
    List<UserJobInteraction> findByJobIdAndUserIdAndInteractionType(String jobId, String userId, String interactionType);
}
