package com.mock.mock_evaluation_system.repository;

import com.mock.mock_evaluation_system.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}