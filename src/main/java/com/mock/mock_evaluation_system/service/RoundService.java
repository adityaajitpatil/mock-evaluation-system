package com.mock.mock_evaluation_system.service;

import com.mock.mock_evaluation_system.dto.RoundDTO;

import java.util.List;

public interface RoundService {

    RoundDTO createRound(RoundDTO dto);

    List<RoundDTO> getAllRounds();

    void deleteRound(Long id);
}