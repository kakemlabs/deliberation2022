/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.MoyenneEc;
import com.essa.deliberation.domain.MoyenneEc;
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
public class MoyenneEcDaoImpl implements MoyenneEcDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertMoyenneEc(MoyenneEc moyenneEc) {
        em.persist(moyenneEc);
    }

    @Override
    public void updateMoyenneEc(MoyenneEc moyenneEc) {
        em.merge(moyenneEc);
    }

    @Override
    public void deleteMoyenneEc(MoyenneEc moyenneEc) {
        em.remove(em.merge(moyenneEc));
    }

    @Override
    public MoyenneEc findMoyenneEcById(int idMoyenneEc) {
        return em.find(MoyenneEc.class, idMoyenneEc);
    }

    @Override
    public List<MoyenneEc> findAllMoyenneEc() {
        String jpql = "SELECT u FROM MoyenneEc u";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countMoyenneEc() {
        String count = "select count(u) from MoyenneEc u";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
