/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.Filiere;
import com.essa.deliberation.service.FiliereService;
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
@Named(value = "filiereBean")
@RequestScoped
public class FiliereBean {

    @Inject
    private FiliereService filiereService;

    private Filiere selectedFiliere;

    List<Filiere> filieres;

    public FiliereBean() {
        System.out.println("Starting ManagedBean FiliereBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        filieres = filiereService.listFilieres();
        selectedFiliere = new Filiere();
    }

    public void editListener(RowEditEvent event) {
        Filiere filiere = (Filiere) event.getObject();
        filiereService.modifyFiliere(filiere);
    }

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public Filiere getSelectedFiliere() {
        return selectedFiliere;
    }

    public void setSelectedFiliere(Filiere selectedFiliere) {
        this.selectedFiliere = selectedFiliere;
    }

    public void restartSelectedFiliere() {
        this.selectedFiliere = new Filiere();
    }

    public void addFiliere() {
        filiereService.addFiliere(this.selectedFiliere);
        //We also add it to the view (refresh the Model)
        this.filieres.add(this.selectedFiliere);
        this.selectedFiliere = null;
    }
    
    public void editFiliere() {
        filiereService.modifyFiliere(this.selectedFiliere);
    }

    public void deleteFiliere() {
        filiereService.deleteFiliere(this.selectedFiliere);
        //We also eliminate it from the view (refresh the Model)
        filieres.remove(this.selectedFiliere);
        this.selectedFiliere = null;
    }
    
}
