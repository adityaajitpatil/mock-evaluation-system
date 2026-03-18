package com.mock.mock_evaluation_system.service;

import com.mock.mock_evaluation_system.dto.EvaluatorAssignmentDTO;

import java.util.List;

public interface EvaluatorAssignmentService {

    EvaluatorAssignmentDTO assignEvaluator(EvaluatorAssignmentDTO dto);

    List<EvaluatorAssignmentDTO> getAllAssignments();

    void deleteAssignment(Long id);
}