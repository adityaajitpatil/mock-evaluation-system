package com.mock.mock_evaluation_system.dto;

import lombok.Data;

@Data
public class EvaluationDTO {

    private Long evaluatorId;

    private Long participantId;

    private Long roundId;

    private Integer score;

    private String feedback;
}