package com.example.mvcproducts.services;

import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.dto.RegisterRequest;


public interface UserService {
  void save(User user);
  User register(RegisterRequest request);
}
