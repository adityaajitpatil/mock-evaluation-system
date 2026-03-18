package com.mock.mock_evaluation_system.service.impl;

import com.mock.mock_evaluation_system.dto.RoundDTO;
import com.mock.mock_evaluation_system.entity.Round;
import com.mock.mock_evaluation_system.entity.Technology;
import com.mock.mock_evaluation_system.repository.RoundRepository;
import com.mock.mock_evaluation_system.repository.TechnologyRepository;
import com.mock.mock_evaluation_system.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoundServiceImpl implements RoundService {

    private final RoundRepository roundRepository;
    private final TechnologyRepository technologyRepository;

    @Override
    public RoundDTO createRound(RoundDTO dto) {

        Technology tech = technologyRepository
                .findById(dto.getTechnologyId())
                .orElseThrow();

        Round round = Round.builder()
                .roundName(dto.getRoundName())
                .technology(tech)
                .build();

        round = roundRepository.save(round);

        return RoundDTO.builder()
                .id(round.getId())
                .roundName(round.getRoundName())
                .technologyId(tech.getId())
                .build();
    }

    @Override
    public List<RoundDTO> getAllRounds() {

        return roundRepository.findAll()
                .stream()
                .map(r -> RoundDTO.builder()
                        .id(r.getId())
                        .roundName(r.getRoundName())
                        .technologyId(r.getTechnology().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRound(Long id) {
        roundRepository.deleteById(id);
    }
}