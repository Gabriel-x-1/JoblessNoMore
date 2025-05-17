package com.example.mvcproducts.repositories;

import com.example.mvcproducts.domain.JobApplication;
import com.example.mvcproducts.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByJob_CompanyUser(User companyUser);
    List<JobApplication> findByApplicant(User applicant);
}
