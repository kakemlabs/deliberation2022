/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Filiere;
import com.essa.deliberation.domain.Filiere;
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
public class FiliereDaoImpl implements FiliereDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertFiliere(Filiere filiere) {
        em.persist(filiere);
    }

    @Override
    public void updateFiliere(Filiere filiere) {
        em.merge(filiere);
    }

    @Override
    public void deleteFiliere(Filiere filiere) {
        em.remove(em.merge(filiere));
    }

    @Override
    public Filiere findFiliereById(int idFiliere) {
        return em.find(Filiere.class, idFiliere);
    }

    @Override
    public List<Filiere> findAllFiliere() {
        String jpql = "SELECT f FROM Filiere f";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countFiliere() {
        String count = "select count(f) from Filiere f";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
