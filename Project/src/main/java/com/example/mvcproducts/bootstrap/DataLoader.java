package com.example.mvcproducts.bootstrap;
import com.example.mvcproducts.domain.Role;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DataLoader implements CommandLineRunner {
  private final UserService userService;

  public DataLoader(UserService userService) {
    this.userService = userService;
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
  }
}
