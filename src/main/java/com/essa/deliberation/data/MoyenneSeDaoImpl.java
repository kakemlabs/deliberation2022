/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.MoyenneSe;
import com.essa.deliberation.domain.MoyenneSe;
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
public class MoyenneSeDaoImpl implements MoyenneSeDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertMoyenneSe(MoyenneSe moyenneSe) {
        em.persist(moyenneSe);
    }

    @Override
    public void updateMoyenneSe(MoyenneSe moyenneSe) {
        em.merge(moyenneSe);
    }

    @Override
    public void deleteMoyenneSe(MoyenneSe moyenneSe) {
        em.remove(em.merge(moyenneSe));
    }

    @Override
    public MoyenneSe findMoyenneSeById(int idMoyenneSe) {
        return em.find(MoyenneSe.class, idMoyenneSe);
    }

    @Override
    public List<MoyenneSe> findAllMoyenneSe() {
        String jpql = "SELECT u FROM MoyenneSe u";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countMoyenneSe() {
        String count = "select count(u) from MoyenneSe u";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
