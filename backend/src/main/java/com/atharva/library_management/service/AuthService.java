package com.atharva.library_management.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.atharva.library_management.dto.AuthResponse;
import com.atharva.library_management.dto.RegisterRequest;
import com.atharva.library_management.dto.auth.LoginRequest;
import com.atharva.library_management.model.Role;
import com.atharva.library_management.model.User;
import com.atharva.library_management.repository.UserRepository;
import com.atharva.library_management.security.JwtService;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = new User(request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                Role.MEMBER);
        userRepository.save(user);
        return new AuthResponse("User registered successfull");
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(
                request.getUsername())
                .orElseThrow(() -> new RuntimeException(
                        "Invalid username or password"));

        boolean passwordMatches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword());

        if (!passwordMatches) {
            throw new RuntimeException(
                    "Invalid username or password");
        }

        String token = jwtService.generateToken(
                user.getUsername());

        return new AuthResponse(token);
    }
}
