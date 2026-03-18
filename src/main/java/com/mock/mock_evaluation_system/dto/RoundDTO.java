package com.mock.mock_evaluation_system.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoundDTO {

    private Long id;

    private String roundName;

    private Long technologyId;
}