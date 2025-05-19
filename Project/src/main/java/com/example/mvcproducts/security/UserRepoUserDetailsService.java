package com.example.mvcproducts.security;

import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepoUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserRepoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("User with email " + email + " not found");
        }
        return user;
    }
}
