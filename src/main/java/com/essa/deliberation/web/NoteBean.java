/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.Note;
import com.essa.deliberation.service.NoteService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author cheik
 */
@Named(value = "noteBean")
@RequestScoped
public class NoteBean {

    @Inject
    private NoteService noteService;

    private Note selectedNote;

    List<Note> notes;

    public NoteBean() {
        System.out.println("Starting ManagedBean NoteBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        notes = noteService.listNotes();
        selectedNote = new Note();
    }

    public void editListener(RowEditEvent event) {
        Note note = (Note) event.getObject();
        noteService.modifyNote(note);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Note getSelectedNote() {
        return selectedNote;
    }

    public void setSelectedNote(Note selectedNote) {
        this.selectedNote = selectedNote;
    }

    public void restartSelectedNote() {
        this.selectedNote = new Note();
    }

    public void addNote() {
        noteService.addNote(this.selectedNote);
        //We also add it to the view (refresh the Model)
        this.notes.add(this.selectedNote);
        this.selectedNote = null;
    }
    
    public void editNote() {
        noteService.modifyNote(this.selectedNote);
    }

    public void deleteNote() {
        noteService.deleteNote(this.selectedNote);
        //We also eliminate it from the view (refresh the Model)
        notes.remove(this.selectedNote);
        this.selectedNote = null;
    }
    
}
