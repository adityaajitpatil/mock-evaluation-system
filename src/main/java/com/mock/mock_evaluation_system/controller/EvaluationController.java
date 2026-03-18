package com.mock.mock_evaluation_system.controller;

import com.mock.mock_evaluation_system.dto.EvaluationDTO;
import com.mock.mock_evaluation_system.service.EvaluationService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluations")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

   // @PreAuthorize("hasRole('EVALUATOR')")
   @PreAuthorize("hasAnyRole('ADMIN','EVALUATOR')")
    @PostMapping
    public EvaluationDTO submitEvaluation(@RequestBody EvaluationDTO dto) {
        return evaluationService.submitEvaluation(dto);
    }
}