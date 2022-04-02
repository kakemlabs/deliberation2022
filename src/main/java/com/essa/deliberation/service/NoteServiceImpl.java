/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.NoteDao;
import com.essa.deliberation.domain.Note;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("userService")
@Transactional
public class NoteServiceImpl implements NoteService {
    @Inject
    private NoteDao noteDao;

    @Override
    public List<Note> listNotes() {
        return noteDao.findAllNote();
    }

    @Override
    public Note findNote(Note note) {
        return noteDao.findNoteById(note.getIdnote());
    }

    @Override
    public void addNote(Note note) {
        noteDao.insertNote(note);
    }

    @Override
    public void modifyNote(Note note) {
        noteDao.updateNote(note);
    }

    @Override
    public void deleteNote(Note note) {
        noteDao.deleteNote(note);
    }
}
