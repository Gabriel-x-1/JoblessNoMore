package com.example.mvcproducts.bootstrap;
import com.example.mvcproducts.domain.Role;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.domain.Job;
import com.example.mvcproducts.services.UserService;
import com.example.mvcproducts.services.JobService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
  private final UserService userService;
  private final JobService jobService;

  public DataLoader(UserService userService, JobService jobService) {
    this.userService = userService;
    this.jobService = jobService;
  }

  @Override
  public void run(String... args) throws Exception {

    PasswordEncoder bcrypt = new BCryptPasswordEncoder();
    User user1=new User("user1",bcrypt.encode("user1"),"user@gmail.com", "user");
    user1.getRoles().add(Role.ROLE_USER);
    User user2=new User("user2",bcrypt.encode("user2"), "company@gmail.com", "company");
    user2.getRoles().add(Role.ROLE_COMPANY);
    userService.save(user1);
    userService.save(user2);

    // Add sample jobs
    Job job1 = new Job(
        "Senior Java Developer",
        "Tech Corp",
        "New York, US",
        "Full-Time",
        "$120,000 - $150,000",
        "We are looking for an experienced Java developer to join our team.",
        List.of("Lead development of core applications", "Mentor junior developers"),
        List.of("5+ years Java experience", "Spring Boot knowledge"),
        LocalDate.now().plusDays(30)
    );

    Job job2 = new Job(
        "Frontend Developer",
        "Web Solutions",
        "Remote",
        "Contract",
        "$80,000 - $100,000",
        "Seeking a skilled frontend developer for our web applications.",
        List.of("Develop responsive UI", "Implement new features"),
        List.of("3+ years React experience", "TypeScript proficiency"),
        LocalDate.now().plusDays(15)
    );

    jobService.saveJob(job1);
    jobService.saveJob(job2);
  }
}
