package com.mock.mock_evaluation_system.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipantDTO {

    private Long id;

    private String name;

    private String email;

    private Long batchId;

    private Long technologyId;
}