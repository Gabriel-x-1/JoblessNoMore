package com.example.mvcproducts.repositories;

import com.example.mvcproducts.domain.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends JpaRepository<Job, Long> {
    
    @Query("SELECT j FROM Job j WHERE j.id NOT IN " +
           "(SELECT p.jobId FROM UserJobPreference p WHERE p.user.id = :userId)")
    Page<Job> findSwipeableJobs(@Param("userId") Long userId, Pageable pageable);
    
    @Query("SELECT j FROM Job j WHERE j.companyUser.id != :userId")
    Page<Job> findAvailableJobsForUser(@Param("userId") Long userId, Pageable pageable);
}
