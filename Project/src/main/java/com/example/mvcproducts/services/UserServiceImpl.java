package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.Role;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.dto.RegisterRequest;
import com.example.mvcproducts.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User register(RegisterRequest request) {
    // Check if email already exists
    if (userRepository.existsByEmail(request.getEmail())) {
      throw new RuntimeException("Email is already registered.");
    }

    if (!request.getPassword().equals(request.getConfirm())) {
      throw new RuntimeException("Passwords do not match.");
    }

    User user = new User();
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    
    // Set role from form input
    String role = request.getRole().toUpperCase();
    user.setRole(role);
    user.getRoles().add(Role.valueOf("ROLE_" + role));

    return userRepository.save(user);
  }

  @Override
  public void save(User user) {
    userRepository.save(user);
  }
}
