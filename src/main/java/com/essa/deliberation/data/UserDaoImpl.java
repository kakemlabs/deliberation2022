/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.User;
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
public class UserDaoImpl implements UserDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertUser(User user) {
        log.info("=== "+ user +" ===");
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(em.merge(user));
    }

    @Override
    public User findUserById(int idUser) {
        return em.find(User.class, idUser);
    }

    @Override
    public List<User> findAllUser() {
        String jpql = "SELECT u FROM User u";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countUser() {
        String count = "select count(u) from User u";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }

}
