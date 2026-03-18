package com.mock.mock_evaluation_system.service.impl;

import com.mock.mock_evaluation_system.repository.EvaluationRepository;
import com.mock.mock_evaluation_system.service.ReportService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final EvaluationRepository evaluationRepository;

    @Override
    public Integer getParticipantTotalScore(Long participantId) {

        Integer score = evaluationRepository.getTotalScoreByParticipant(participantId);

        return score != null ? score : 0;
    }

    @Override
    public Double getRoundAverageScore(Long roundId) {

        Double avg = evaluationRepository.getAverageScoreByRound(roundId);

        return avg != null ? avg : 0.0;
    }

    @Override
    public String exportEvaluationReport() {

        StringBuilder csv = new StringBuilder();

        csv.append("Participant,Round,Score\n");
        csv.append("Rahul,Technical,8\n");
        csv.append("Priya,HR,9\n");

        return csv.toString();
    }
}