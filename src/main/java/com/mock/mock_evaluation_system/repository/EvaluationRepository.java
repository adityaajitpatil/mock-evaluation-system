package com.mock.mock_evaluation_system.repository;

import com.mock.mock_evaluation_system.entity.Evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    @Query("SELECT SUM(e.score) FROM Evaluation e WHERE e.participant.id = :participantId")
    Integer getTotalScoreByParticipant(@Param("participantId") Long participantId);

    @Query("SELECT AVG(e.score) FROM Evaluation e WHERE e.round.id = :roundId")
    Double getAverageScoreByRound(@Param("roundId") Long roundId);

    @Query("SELECT e FROM Evaluation e WHERE e.participant.batch.id = :batchId")
    List<Evaluation> getEvaluationsByBatch(@Param("batchId") Long batchId);

    @Query("SELECT AVG(e.score) FROM Evaluation e")
    Double getAverageScore();
}