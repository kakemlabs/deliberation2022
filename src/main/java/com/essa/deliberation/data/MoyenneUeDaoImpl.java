/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.MoyenneUe;
import com.essa.deliberation.domain.MoyenneUe;
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
public class MoyenneUeDaoImpl implements MoyenneUeDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertMoyenneUe(MoyenneUe moyenneUe) {
        em.persist(moyenneUe);
    }

    @Override
    public void updateMoyenneUe(MoyenneUe moyenneUe) {
        em.merge(moyenneUe);
    }

    @Override
    public void deleteMoyenneUe(MoyenneUe moyenneUe) {
        em.remove(em.merge(moyenneUe));
    }

    @Override
    public MoyenneUe findMoyenneUeById(int idMoyenneUe) {
        return em.find(MoyenneUe.class, idMoyenneUe);
    }

    @Override
    public List<MoyenneUe> findAllMoyenneUe() {
        String jpql = "SELECT u FROM MoyenneUe u";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countMoyenneUe() {
        String count = "select count(u) from MoyenneUe u";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
