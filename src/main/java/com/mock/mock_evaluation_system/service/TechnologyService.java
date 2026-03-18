package com.mock.mock_evaluation_system.service;

import com.mock.mock_evaluation_system.dto.TechnologyDTO;

import java.util.List;

public interface TechnologyService {

    TechnologyDTO createTechnology(TechnologyDTO dto);

    List<TechnologyDTO> getAllTechnologies();

    void deleteTechnology(Long id);
}