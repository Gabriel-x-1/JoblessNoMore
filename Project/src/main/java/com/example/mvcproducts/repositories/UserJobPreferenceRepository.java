package com.example.mvcproducts.repositories;

import com.example.mvcproducts.domain.UserJobPreference;
import com.example.mvcproducts.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJobPreferenceRepository extends JpaRepository<UserJobPreference, Long> {
    List<UserJobPreference> findByUser(User user);
    List<UserJobPreference> findByUserAndLiked(User user, boolean liked);
}
