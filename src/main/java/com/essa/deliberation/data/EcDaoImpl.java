/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Ec;
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
public class EcDaoImpl implements EcDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertEc(Ec ec) {
        em.persist(ec);
    }

    @Override
    public void updateEc(Ec ec) {
        em.merge(ec);
    }

    @Override
    public void deleteEc(Ec ec) {
        em.remove(em.merge(ec));
    }

    @Override
    public Ec findEcById(int idEc) {
        return em.find(Ec.class, idEc);
    }

    @Override
    public List<Ec> findAllEc() {
        String jpql = "SELECT e FROM Ec e";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countEc() {
        String count = "select count(e) from Ec e";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
