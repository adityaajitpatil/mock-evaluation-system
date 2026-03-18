package com.mock.mock_evaluation_system.controller;

import com.mock.mock_evaluation_system.dto.TechnologyDTO;
import com.mock.mock_evaluation_system.service.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
@RequiredArgsConstructor
public class TechnologyController {

    private final TechnologyService technologyService;

    @PostMapping
    public TechnologyDTO createTechnology(@RequestBody TechnologyDTO dto) {
        return technologyService.createTechnology(dto);
    }

    @GetMapping
    public List<TechnologyDTO> getAllTechnologies() {
        return technologyService.getAllTechnologies();
    }

    @DeleteMapping("/{id}")
    public void deleteTechnology(@PathVariable Long id) {
        technologyService.deleteTechnology(id);
    }
}