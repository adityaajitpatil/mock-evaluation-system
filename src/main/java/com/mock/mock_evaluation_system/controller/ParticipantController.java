package com.mock.mock_evaluation_system.controller;

import com.mock.mock_evaluation_system.dto.ParticipantDTO;
import com.mock.mock_evaluation_system.service.ParticipantService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ParticipantDTO createParticipant(@RequestBody ParticipantDTO dto) {
        return participantService.createParticipant(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EVALUATOR')")
    @GetMapping
    public List<ParticipantDTO> getAllParticipants() {
        return participantService.getAllParticipants();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
    }


}