/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Profil;
import com.essa.deliberation.domain.Profil;
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
public class ProfilDaoImpl implements ProfilDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertProfil(Profil profil) {
        em.persist(profil);
    }

    @Override
    public void updateProfil(Profil profil) {
        em.merge(profil);
    }

    @Override
    public void deleteProfil(Profil profil) {
        em.remove(em.merge(profil));
    }

    @Override
    public Profil findProfilById(int idProfil) {
        return em.find(Profil.class, idProfil);
    }

    @Override
    public List<Profil> findAllProfil() {
        String jpql = "SELECT p FROM Profil p";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countProfil() {
        String count = "select count(p) from Profil p";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
