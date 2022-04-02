/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Niveau;
import com.essa.deliberation.domain.Niveau;
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
public class NiveauDaoImpl implements NiveauDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertNiveau(Niveau niveau) {
        em.persist(niveau);
    }

    @Override
    public void updateNiveau(Niveau niveau) {
        em.merge(niveau);
    }

    @Override
    public void deleteNiveau(Niveau niveau) {
        em.remove(em.merge(niveau));
    }

    @Override
    public Niveau findNiveauById(int idNiveau) {
        return em.find(Niveau.class, idNiveau);
    }

    @Override
    public List<Niveau> findAllNiveau() {
        String jpql = "SELECT u FROM Niveau u";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countNiveau() {
        String count = "select count(u) from Niveau u";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }

}
