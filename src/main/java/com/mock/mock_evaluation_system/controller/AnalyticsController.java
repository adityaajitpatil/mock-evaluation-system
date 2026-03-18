package com.mock.mock_evaluation_system.controller;

import com.mock.mock_evaluation_system.dto.DashboardStatsDTO;
import com.mock.mock_evaluation_system.service.AnalyticsService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/dashboard")
    public DashboardStatsDTO dashboardStats(){

        return analyticsService.getDashboardStats();
    }
}