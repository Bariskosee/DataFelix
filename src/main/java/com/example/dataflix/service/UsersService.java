package com.example.dataflix.service;

import com.example.dataflix.model.Users;
import com.example.dataflix.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Users registerUser(Users user) throws Exception {
        if (usersRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    public Optional<Users> login(String email, String password) {
        Optional<Users> userOpt = usersRepository.findByEmail(email);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }

    public Optional<Users> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
    public Optional<Users> findByUserId(Long userId) {
        return usersRepository.findByUserId(userId);
    }
} 