package com.mock.mock_evaluation_system.dto;

public class DashboardStatsDTO {

    private Long totalParticipants;
    private Long totalBatches;
    private Long totalEvaluations;
    private Double averageScore;

    public DashboardStatsDTO() {}

    public DashboardStatsDTO(Long totalParticipants,
                             Long totalBatches,
                             Long totalEvaluations,
                             Double averageScore) {

        this.totalParticipants = totalParticipants;
        this.totalBatches = totalBatches;
        this.totalEvaluations = totalEvaluations;
        this.averageScore = averageScore;
    }

    public Long getTotalParticipants() {
        return totalParticipants;
    }

    public Long getTotalBatches() {
        return totalBatches;
    }

    public Long getTotalEvaluations() {
        return totalEvaluations;
    }

    public Double getAverageScore() {
        return averageScore;
    }
}