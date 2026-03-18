package com.mock.mock_evaluation_system.controller;

import com.mock.mock_evaluation_system.entity.User;
import com.mock.mock_evaluation_system.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public User createUser(@RequestBody User user){

        return userService.createUser(user);

    }
}