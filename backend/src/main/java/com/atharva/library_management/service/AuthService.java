package com.atharva.library_management.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.atharva.library_management.dto.AuthResponse;
import com.atharva.library_management.dto.RegisterRequest;
import com.atharva.library_management.model.Role;
import com.atharva.library_management.model.User;
import com.atharva.library_management.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = new User(request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                Role.MEMBER);
        userRepository.save(user);
        return new AuthResponse("User registered successfull");
    }
}
