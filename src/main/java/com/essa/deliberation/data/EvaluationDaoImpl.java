/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Evaluation;
import com.essa.deliberation.domain.Evaluation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cheik
 */
@Repository
public class EvaluationDaoImpl implements EvaluationDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertEvaluation(Evaluation evaluation) {
        em.persist(evaluation);
    }

    @Override
    public void updateEvaluation(Evaluation evaluation) {
        em.merge(evaluation);
    }

    @Override
    public void deleteEvaluation(Evaluation evaluation) {
        em.remove(em.merge(evaluation));
    }

    @Override
    public Evaluation findEvaluationById(int idEvaluation) {
        return em.find(Evaluation.class, idEvaluation);
    }

    @Override
    public List<Evaluation> findAllEvaluation() {
        String jpql = "SELECT e FROM Evaluation e";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countEvaluation() {
        String count = "select count(e) from Evaluation e";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
