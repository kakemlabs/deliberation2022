/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Semestre;
import com.essa.deliberation.domain.Semestre;
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
public class SemestreDaoImpl implements SemestreDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertSemestre(Semestre semestre) {
        em.persist(semestre);
    }

    @Override
    public void updateSemestre(Semestre semestre) {
        em.merge(semestre);
    }

    @Override
    public void deleteSemestre(Semestre semestre) {
        em.remove(em.merge(semestre));
    }

    @Override
    public Semestre findSemestreById(int idSemestre) {
        return em.find(Semestre.class, idSemestre);
    }

    @Override
    public List<Semestre> findAllSemestre() {
        String jpql = "SELECT s FROM Semestre s";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countSemestre() {
        String count = "select count(s) from Semestre s";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
