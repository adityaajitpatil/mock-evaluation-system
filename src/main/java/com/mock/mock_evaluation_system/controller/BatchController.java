package com.mock.mock_evaluation_system.controller;

import com.mock.mock_evaluation_system.dto.BatchDTO;
import com.mock.mock_evaluation_system.service.BatchService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public BatchDTO createBatch(@RequestBody BatchDTO batchDTO) {
        return batchService.createBatch(batchDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN','EVALUATOR')")
    @GetMapping
    public List<BatchDTO> getAllBatches() {
        return batchService.getAllBatches();
    }

    @PreAuthorize("hasAnyRole('ADMIN','EVALUATOR')")
    @GetMapping("/{id}")
    public BatchDTO getBatchById(@PathVariable Long id) {
        return batchService.getBatchById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteBatch(@PathVariable Long id) {
        batchService.deleteBatch(id);
    }
}