/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.Evaluation;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface EvaluationService {
    public List<Evaluation> listEvaluations();

    public Evaluation findEvaluation(Evaluation evaluation);

    public void addEvaluation(Evaluation evaluation);

    public void modifyEvaluation(Evaluation evaluation);

    public void deleteEvaluation(Evaluation evaluation);
}
