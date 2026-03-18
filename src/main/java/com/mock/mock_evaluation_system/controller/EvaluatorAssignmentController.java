package com.mock.mock_evaluation_system.controller;

import com.mock.mock_evaluation_system.dto.EvaluatorAssignmentDTO;
import com.mock.mock_evaluation_system.service.EvaluatorAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class EvaluatorAssignmentController {

    private final EvaluatorAssignmentService assignmentService;

    @PostMapping
    public EvaluatorAssignmentDTO assignEvaluator(
            @RequestBody EvaluatorAssignmentDTO dto) {

        return assignmentService.assignEvaluator(dto);
    }

    @GetMapping
    public List<EvaluatorAssignmentDTO> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
    }
}