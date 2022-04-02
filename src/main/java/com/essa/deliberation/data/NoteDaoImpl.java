/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Note;
import com.essa.deliberation.domain.Note;
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
public class NoteDaoImpl implements NoteDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertNote(Note note) {
        em.persist(note);
    }

    @Override
    public void updateNote(Note note) {
        em.merge(note);
    }

    @Override
    public void deleteNote(Note note) {
        em.remove(em.merge(note));
    }

    @Override
    public Note findNoteById(int idNote) {
        return em.find(Note.class, idNote);
    }

    @Override
    public List<Note> findAllNote() {
        String jpql = "SELECT u FROM Note u";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public long countNote() {
        String count = "select count(u) from Note u";
        Query q = em.createQuery(count);
        return (long) q.getSingleResult();
    }
    
}
