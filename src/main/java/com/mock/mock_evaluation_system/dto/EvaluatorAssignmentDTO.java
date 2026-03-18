package com.mock.mock_evaluation_system.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluatorAssignmentDTO {

    private Long id;

    private Long evaluatorId;

    private Long participantId;

    private Long roundId;
}