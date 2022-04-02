/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.Note;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface NoteService {
    public List<Note> listNotes();

    public Note findNote(Note note);

    public void addNote(Note note);

    public void modifyNote(Note note);

    public void deleteNote(Note note);
}
