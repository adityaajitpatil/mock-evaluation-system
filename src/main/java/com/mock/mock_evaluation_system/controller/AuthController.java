package com.mock.mock_evaluation_system.controller;

import com.mock.mock_evaluation_system.dto.LoginRequest;
import com.mock.mock_evaluation_system.dto.LoginResponse;
import com.mock.mock_evaluation_system.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){

        return authService.login(request);

    }

}