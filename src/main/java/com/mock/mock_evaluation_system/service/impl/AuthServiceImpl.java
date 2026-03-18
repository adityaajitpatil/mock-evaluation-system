package com.mock.mock_evaluation_system.service.impl;

import com.mock.mock_evaluation_system.dto.LoginRequest;
import com.mock.mock_evaluation_system.dto.LoginResponse;
import com.mock.mock_evaluation_system.entity.User;
import com.mock.mock_evaluation_system.repository.UserRepository;
import com.mock.mock_evaluation_system.security.JwtUtil;
import com.mock.mock_evaluation_system.service.AuthService;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository,
                           JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }


    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Plain password comparison
        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        System.out.println("ROLE = " + user.getRole().getName());

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole().getName()
        );


        return new LoginResponse(token, user.getRole().getName());
    }
}