package com.mock.mock_evaluation_system.service.impl;

import com.mock.mock_evaluation_system.dto.EvaluatorAssignmentDTO;
import com.mock.mock_evaluation_system.entity.*;
import com.mock.mock_evaluation_system.repository.*;
import com.mock.mock_evaluation_system.service.EvaluatorAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EvaluatorAssignmentServiceImpl
        implements EvaluatorAssignmentService {

    private final EvaluatorAssignmentRepository assignmentRepository;
    private final UserRepository userRepository;
    private final ParticipantRepository participantRepository;
    private final RoundRepository roundRepository;

    @Override
    public EvaluatorAssignmentDTO assignEvaluator(EvaluatorAssignmentDTO dto) {

        User evaluator = userRepository
                .findById(dto.getEvaluatorId())
                .orElseThrow();

        Participant participant = participantRepository
                .findById(dto.getParticipantId())
                .orElseThrow();

        Round round = roundRepository
                .findById(dto.getRoundId())
                .orElseThrow();

        EvaluatorAssignment assignment = EvaluatorAssignment.builder()
                .evaluator(evaluator)
                .participant(participant)
                .round(round)
                .build();

        assignment = assignmentRepository.save(assignment);

        return EvaluatorAssignmentDTO.builder()
                .id(assignment.getId())
                .evaluatorId(evaluator.getId())
                .participantId(participant.getId())
                .roundId(round.getId())
                .build();
    }

    @Override
    public List<EvaluatorAssignmentDTO> getAllAssignments() {

        return assignmentRepository.findAll()
                .stream()
                .map(a -> EvaluatorAssignmentDTO.builder()
                        .id(a.getId())
                        .evaluatorId(a.getEvaluator().getId())
                        .participantId(a.getParticipant().getId())
                        .roundId(a.getRound().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}