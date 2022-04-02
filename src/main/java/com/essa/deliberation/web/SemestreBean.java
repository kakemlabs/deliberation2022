/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.Semestre;
import com.essa.deliberation.service.SemestreService;
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
@Named(value = "semestreBean")
@RequestScoped
public class SemestreBean {

    @Inject
    private SemestreService semestreService;

    private Semestre selectedSemestre;

    List<Semestre> semestres;

    public SemestreBean() {
        System.out.println("Starting ManagedBean SemestreBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        semestres = semestreService.listSemestres();
        selectedSemestre = new Semestre();
    }

    public void editListener(RowEditEvent event) {
        Semestre semestre = (Semestre) event.getObject();
        semestreService.modifySemestre(semestre);
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }

    public Semestre getSelectedSemestre() {
        return selectedSemestre;
    }

    public void setSelectedSemestre(Semestre selectedSemestre) {
        this.selectedSemestre = selectedSemestre;
    }

    public void restartSelectedSemestre() {
        this.selectedSemestre = new Semestre();
    }

    public void addSemestre() {
        semestreService.addSemestre(this.selectedSemestre);
        //We also add it to the view (refresh the Model)
        this.semestres.add(this.selectedSemestre);
        this.selectedSemestre = null;
    }
    
    public void editSemestre() {
        semestreService.modifySemestre(this.selectedSemestre);
    }

    public void deleteSemestre() {
        semestreService.deleteSemestre(this.selectedSemestre);
        //We also eliminate it from the view (refresh the Model)
        semestres.remove(this.selectedSemestre);
        this.selectedSemestre = null;
    }
    
}
