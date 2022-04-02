/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.EtudiantPromo;
import com.essa.deliberation.domain.EtudiantPromo;
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
public class EtudiantPromoDaoImpl implements EtudiantPromoDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertEtudiantPromo(EtudiantPromo etudiantPromo) {
        em.persist(etudiantPromo);
    }

    @Override
    public void updateEtudiantPromo(EtudiantPromo etudiantPromo) {
        em.merge(etudiantPromo);
    }

    @Override
    public void deleteEtudiantPromo(EtudiantPromo etudiantPromo) {
        em.remove(em.merge(etudiantPromo));
    }

    @Override
    public EtudiantPromo findEtudiantPromoById(int idEtudiantPromo) {
        return em.find(EtudiantPromo.class, idEtudiantPromo);
    }

    @Override
    public List<EtudiantPromo> findAllEtudiantPromo() {
        String jpql = "SELECT e FROM EtudiantPromo e";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countEtudiantPromo() {
        String count = "select count(e) from EtudiantPromo e";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
