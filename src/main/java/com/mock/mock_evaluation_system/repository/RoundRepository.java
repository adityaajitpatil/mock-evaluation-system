package com.mock.mock_evaluation_system.repository;

import com.mock.mock_evaluation_system.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundRepository extends JpaRepository<Round, Long> {
}