/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Evaluation;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface EvaluationDao {
    void insertEvaluation(Evaluation evaluation);

    void updateEvaluation(Evaluation evaluation);

    void deleteEvaluation(Evaluation evaluation);

    Evaluation findEvaluationById(int idEvaluation);

    List<Evaluation> findAllEvaluation();

    long countEvaluation();
}
