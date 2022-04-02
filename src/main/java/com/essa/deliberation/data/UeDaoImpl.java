/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Ue;
import com.essa.deliberation.domain.Ue;
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
public class UeDaoImpl implements UeDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertUe(Ue ue) {
        em.persist(ue);
    }

    @Override
    public void updateUe(Ue ue) {
        em.merge(ue);
    }

    @Override
    public void deleteUe(Ue ue) {
        em.remove(em.merge(ue));
    }

    @Override
    public Ue findUeById(int idUe) {
        return em.find(Ue.class, idUe);
    }

    @Override
    public List<Ue> findAllUe() {
        String jpql = "SELECT u FROM Ue u";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countUe() {
        String count = "select count(u) from Ue u";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
