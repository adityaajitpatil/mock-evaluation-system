package com.mock.mock_evaluation_system.service.impl;

import com.mock.mock_evaluation_system.dto.ParticipantDTO;
import com.mock.mock_evaluation_system.entity.Batch;
import com.mock.mock_evaluation_system.entity.Participant;
import com.mock.mock_evaluation_system.entity.Technology;
import com.mock.mock_evaluation_system.repository.BatchRepository;
import com.mock.mock_evaluation_system.repository.ParticipantRepository;
import com.mock.mock_evaluation_system.repository.TechnologyRepository;
import com.mock.mock_evaluation_system.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;
    private final BatchRepository batchRepository;
    private final TechnologyRepository technologyRepository;

    @Override
    public ParticipantDTO createParticipant(ParticipantDTO dto) {

        Batch batch = batchRepository.findById(dto.getBatchId()).orElseThrow();
        Technology tech = technologyRepository.findById(dto.getTechnologyId()).orElseThrow();

        Participant participant = Participant.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .batch(batch)
                .technology(tech)
                .build();

        participant = participantRepository.save(participant);

        return ParticipantDTO.builder()
                .id(participant.getId())
                .name(participant.getName())
                .email(participant.getEmail())
                .batchId(batch.getId())
                .technologyId(tech.getId())
                .build();
    }

    @Override
    public List<ParticipantDTO> getAllParticipants() {

        return participantRepository.findAll()
                .stream()
                .map(p -> ParticipantDTO.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .email(p.getEmail())
                        .batchId(p.getBatch().getId())
                        .technologyId(p.getTechnology().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}