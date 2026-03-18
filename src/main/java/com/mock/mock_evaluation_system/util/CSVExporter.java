package com.mock.mock_evaluation_system.util;

import com.mock.mock_evaluation_system.entity.Evaluation;
import java.util.List;

public class CSVExporter {

    public static String exportEvaluations(List<Evaluation> evaluations) {

        StringBuilder csv = new StringBuilder();

        csv.append("Participant,Round,Score,Feedback\n");

        for (Evaluation e : evaluations) {

            csv.append(e.getParticipant().getName()).append(",");
            csv.append(e.getRound().getRoundName()).append(",");
            csv.append(e.getScore()).append(",");
            csv.append(e.getFeedback()).append("\n");

        }

        return csv.toString();
    }
}