package com.mock.mock_evaluation_system.service;

import com.mock.mock_evaluation_system.dto.LoginRequest;
import com.mock.mock_evaluation_system.dto.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

}