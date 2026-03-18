package com.mock.mock_evaluation_system.controller;

import com.mock.mock_evaluation_system.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PreAuthorize("hasAnyRole('ADMIN','EVALUATOR')")
    @GetMapping("/participant/{id}")
    public Integer getParticipantTotalScore(@PathVariable Long id) {
        return reportService.getParticipantTotalScore(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EVALUATOR')")
    @GetMapping("/round/{id}")
    public Double getRoundAverageScore(@PathVariable Long id) {
        return reportService.getRoundAverageScore(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/export")
    public String exportReport() {
        return reportService.exportEvaluationReport();
    }
}