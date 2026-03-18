package com.mock.mock_evaluation_system.service;

import com.mock.mock_evaluation_system.dto.ParticipantDTO;

import java.util.List;

public interface ParticipantService {

    ParticipantDTO createParticipant(ParticipantDTO dto);

    List<ParticipantDTO> getAllParticipants();

    void deleteParticipant(Long id);
}