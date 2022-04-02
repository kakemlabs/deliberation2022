/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.Niveau;
import com.essa.deliberation.service.NiveauService;
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
@Named(value = "niveauBean")
@RequestScoped
public class NiveauBean {

    @Inject
    private NiveauService niveauService;

    private Niveau selectedNiveau;

    List<Niveau> niveaus;

    public NiveauBean() {
        System.out.println("Starting ManagedBean NiveauBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        niveaus = niveauService.listNiveaux();
        selectedNiveau = new Niveau();
    }

    public void editListener(RowEditEvent event) {
        Niveau niveau = (Niveau) event.getObject();
        niveauService.modifyNiveau(niveau);
    }

    public List<Niveau> getNiveaus() {
        return niveaus;
    }

    public void setNiveaus(List<Niveau> niveaus) {
        this.niveaus = niveaus;
    }

    public Niveau getSelectedNiveau() {
        return selectedNiveau;
    }

    public void setSelectedNiveau(Niveau selectedNiveau) {
        this.selectedNiveau = selectedNiveau;
    }

    public void restartSelectedNiveau() {
        this.selectedNiveau = new Niveau();
    }

    public void addNiveau() {
        niveauService.addNiveau(this.selectedNiveau);
        //We also add it to the view (refresh the Model)
        this.niveaus.add(this.selectedNiveau);
        this.selectedNiveau = null;
    }
    
    public void editNiveau() {
        niveauService.modifyNiveau(this.selectedNiveau);
    }

    public void deleteNiveau() {
        niveauService.deleteNiveau(this.selectedNiveau);
        //We also eliminate it from the view (refresh the Model)
        niveaus.remove(this.selectedNiveau);
        this.selectedNiveau = null;
    }
    
}
