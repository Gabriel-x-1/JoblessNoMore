package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.dto.RegisterRequest;
import com.example.mvcproducts.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    if (!request.getPassword().equals(request.getConfirm())) {
      throw new RuntimeException("Passwords do not match");
    }

    if (userRepository.existsByEmail(request.getEmail())) {
      throw new RuntimeException("Email already registered");
    }

    User user = new User();
    user.setUsername(request.getName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setRole(request.getRole());

    return userRepository.save(user);
  }

  @Override
  public void save(User user) {
    userRepository.save(user);
  }
}
