package com.mock.mock_evaluation_system.repository;

import com.mock.mock_evaluation_system.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}