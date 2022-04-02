/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Promo;
import com.essa.deliberation.domain.Promo;
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
public class PromoDaoImpl implements PromoDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertPromo(Promo promo) {
        em.persist(promo);
    }

    @Override
    public void updatePromo(Promo promo) {
        em.merge(promo);
    }

    @Override
    public void deletePromo(Promo promo) {
        em.remove(em.merge(promo));
    }

    @Override
    public Promo findPromoById(int idPromo) {
        return em.find(Promo.class, idPromo);
    }

    @Override
    public List<Promo> findAllPromo() {
        String jpql = "SELECT p FROM Promo p";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countPromo() {
        String count = "select count(p) from Promo p";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
