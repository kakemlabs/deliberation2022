package com.essa.deliberation.data;

import com.essa.deliberation.domain.Etudiant;
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
public class EtudiantDaoImpl implements EtudiantDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertEtudiant(Etudiant etudiant) {
        em.persist(etudiant);
    }

    @Override
    public void updateEtudiant(Etudiant etudiant) {
        em.merge(etudiant);
    }

    @Override
    public void deleteEtudiant(Etudiant etudiant) {
        em.remove(em.merge(etudiant));
    }

    @Override
    public Etudiant findEtudiantById(int idEtudiant) {
        return em.find(Etudiant.class, idEtudiant);
    }

    @Override
    public List<Etudiant> findAllEtudiant() {
        String jpql = "SELECT e FROM Etudiant e";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countEtudiant() {
        String count = "select count(e) from Etudiant e";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
