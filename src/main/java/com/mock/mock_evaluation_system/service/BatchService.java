package com.mock.mock_evaluation_system.service;

import com.mock.mock_evaluation_system.dto.BatchDTO;
import java.util.List;

public interface BatchService {

    BatchDTO createBatch(BatchDTO batchDTO);

    List<BatchDTO> getAllBatches();

    BatchDTO getBatchById(Long id);

    void deleteBatch(Long id);

}