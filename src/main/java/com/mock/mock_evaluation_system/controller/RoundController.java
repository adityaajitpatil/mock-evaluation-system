package com.mock.mock_evaluation_system.controller;

import com.mock.mock_evaluation_system.dto.RoundDTO;
import com.mock.mock_evaluation_system.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rounds")
@RequiredArgsConstructor
public class RoundController {

    private final RoundService roundService;

    @PostMapping
    public RoundDTO createRound(@RequestBody RoundDTO dto) {
        return roundService.createRound(dto);
    }

    @GetMapping
    public List<RoundDTO> getAllRounds() {
        return roundService.getAllRounds();
    }

    @DeleteMapping("/{id}")
    public void deleteRound(@PathVariable Long id) {
        roundService.deleteRound(id);
    }
}