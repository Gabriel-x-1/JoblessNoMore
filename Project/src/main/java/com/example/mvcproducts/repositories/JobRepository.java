package com.example.mvcproducts.repositories;

import com.example.mvcproducts.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, String> {
    List<Job> findByCompany(String company);
}
