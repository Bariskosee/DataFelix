package com.example.dataflix.service;

import com.example.dataflix.model.User;
import com.example.dataflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Long getCurrentUserId(Principal principal) {
        if (principal == null) {
            throw new IllegalStateException("No authenticated user");
        }
        String email = principal.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("User not found: " + email));
        return user.getUserId();
    }
} 