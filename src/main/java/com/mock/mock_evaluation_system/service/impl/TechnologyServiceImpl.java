package com.mock.mock_evaluation_system.service.impl;

import com.mock.mock_evaluation_system.dto.TechnologyDTO;
import com.mock.mock_evaluation_system.entity.Technology;
import com.mock.mock_evaluation_system.repository.TechnologyRepository;
import com.mock.mock_evaluation_system.service.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository technologyRepository;

    @Override
    public TechnologyDTO createTechnology(TechnologyDTO dto) {

        Technology tech = Technology.builder()
                .technologyName(dto.getTechnologyName())
                .build();

        tech = technologyRepository.save(tech);

        return TechnologyDTO.builder()
                .id(tech.getId())
                .technologyName(tech.getTechnologyName())
                .build();
    }

    @Override
    public List<TechnologyDTO> getAllTechnologies() {

        return technologyRepository.findAll()
                .stream()
                .map(t -> TechnologyDTO.builder()
                        .id(t.getId())
                        .technologyName(t.getTechnologyName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTechnology(Long id) {
        technologyRepository.deleteById(id);
    }
}