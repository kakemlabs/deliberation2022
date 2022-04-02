/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.EvaluationDao;
import com.essa.deliberation.domain.Evaluation;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("evaluationService")
@Transactional
public class EvaluationServiceImpl implements EvaluationService {
    @Inject
    private EvaluationDao evaluationDao;

    @Override
    public List<Evaluation> listEvaluations() {
        return evaluationDao.findAllEvaluation();
    }

    @Override
    public Evaluation findEvaluation(Evaluation evaluation) {
        return evaluationDao.findEvaluationById(evaluation.getIdevaluation());
    }

    @Override
    public void addEvaluation(Evaluation evaluation) {
        evaluationDao.insertEvaluation(evaluation);
    }

    @Override
    public void modifyEvaluation(Evaluation evaluation) {
        evaluationDao.updateEvaluation(evaluation);
    }

    @Override
    public void deleteEvaluation(Evaluation evaluation) {
        evaluationDao.deleteEvaluation(evaluation);
    }
}
