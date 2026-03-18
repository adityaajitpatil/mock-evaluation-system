package com.mock.mock_evaluation_system.service.impl;

import com.mock.mock_evaluation_system.dto.DashboardStatsDTO;
import com.mock.mock_evaluation_system.repository.*;

import com.mock.mock_evaluation_system.service.AnalyticsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {

    private final ParticipantRepository participantRepository;
    private final BatchRepository batchRepository;
    private final EvaluationRepository evaluationRepository;

    @Override
    public DashboardStatsDTO getDashboardStats() {

        Long participants = participantRepository.count();
        Long batches = batchRepository.count();
        Long evaluations = evaluationRepository.count();
        Double avgScore = evaluationRepository.getAverageScore();

        return new DashboardStatsDTO(
                participants,
                batches,
                evaluations,
                avgScore
        );
    }
}