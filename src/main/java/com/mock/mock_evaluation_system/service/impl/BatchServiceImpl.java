package com.mock.mock_evaluation_system.service.impl;


import com.mock.mock_evaluation_system.dto.BatchDTO;
import com.mock.mock_evaluation_system.entity.Batch;
import com.mock.mock_evaluation_system.repository.BatchRepository;
import com.mock.mock_evaluation_system.service.BatchService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public BatchDTO createBatch(BatchDTO batchDTO) {

        Batch batch = new Batch();
        batch.setBatchName(batchDTO.getBatchName());
        batch.setStartDate(batchDTO.getStartDate());
        batch.setEndDate(batchDTO.getEndDate());

        Batch saved = batchRepository.save(batch);

        batchDTO.setId(saved.getId());
        return batchDTO;
    }

    @Override
    public List<BatchDTO> getAllBatches() {

        return batchRepository.findAll()
                .stream()
                .map(batch -> {
                    BatchDTO dto = new BatchDTO();
                    dto.setId(batch.getId());
                    dto.setBatchName(batch.getBatchName());
                    dto.setStartDate(batch.getStartDate());
                    dto.setEndDate(batch.getEndDate());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BatchDTO getBatchById(Long id) {

        Batch batch = batchRepository.findById(id).orElseThrow();

        BatchDTO dto = new BatchDTO();
        dto.setId(batch.getId());
        dto.setBatchName(batch.getBatchName());
        dto.setStartDate(batch.getStartDate());
        dto.setEndDate(batch.getEndDate());

        return dto;
    }

    @Override
    public void deleteBatch(Long id) {

        batchRepository.deleteById(id);

    }
}