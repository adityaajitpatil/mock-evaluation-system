package com.mock.mock_evaluation_system.service.impl;

import com.mock.mock_evaluation_system.dto.EvaluationDTO;
import com.mock.mock_evaluation_system.entity.*;
import com.mock.mock_evaluation_system.repository.*;
import com.mock.mock_evaluation_system.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final UserRepository userRepository;
    private final ParticipantRepository participantRepository;
    private final RoundRepository roundRepository;

    @Override
    public EvaluationDTO submitEvaluation(EvaluationDTO dto) {

        User evaluator = userRepository.findById(dto.getEvaluatorId())
                .orElseThrow(() -> new RuntimeException("Evaluator not found"));

        Participant participant = participantRepository.findById(dto.getParticipantId())
                .orElseThrow(() -> new RuntimeException("Participant not found"));

        Round round = roundRepository.findById(dto.getRoundId())
                .orElseThrow(() -> new RuntimeException("Round not found"));

        Evaluation evaluation = new Evaluation();
        evaluation.setEvaluator(evaluator);
        evaluation.setParticipant(participant);
        evaluation.setRound(round);
        evaluation.setScore(dto.getScore());
        evaluation.setFeedback(dto.getFeedback());

        evaluationRepository.save(evaluation);

        return dto;
    }
}