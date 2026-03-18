package com.mock.mock_evaluation_system.service;

public interface ReportService {

    Integer getParticipantTotalScore(Long participantId);

    Double getRoundAverageScore(Long roundId);

    String exportEvaluationReport();
}