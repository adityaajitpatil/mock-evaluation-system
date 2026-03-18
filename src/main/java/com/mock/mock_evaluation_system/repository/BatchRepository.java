package com.mock.mock_evaluation_system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.mock.mock_evaluation_system.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long> {

}