/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Note;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface NoteDao {
    void insertNote(Note note);

    void updateNote(Note note);

    void deleteNote(Note note);

    Note findNoteById(int idNote);

    List<Note> findAllNote();

    long countNote();
}
