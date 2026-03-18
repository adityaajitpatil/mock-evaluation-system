package com.mock.mock_evaluation_system.repository;

import com.mock.mock_evaluation_system.entity.EvaluatorAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluatorAssignmentRepository
        extends JpaRepository<EvaluatorAssignment, Long> {
}