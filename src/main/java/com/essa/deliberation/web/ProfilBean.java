/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.Profil;
import com.essa.deliberation.service.ProfilService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author cheik
 */
@Named(value = "profilBean")
@RequestScoped
public class ProfilBean {
    
    @Inject
    private ProfilService profilService;

    private Profil selectedProfil;

    List<Profil> profils;
    
    /**
     * Creates a new instance of ProfilBean
     */
    public ProfilBean() {
        System.out.println("Starting ManagedBean ProfilBean");
    }

    /**
     *
     */
    @PostConstruct
    public void init() {
        //We start the variables
        profils = profilService.listProfils();
        selectedProfil = new Profil();
    }

    /**
     *
     * @param event
     */
    public void editListener(RowEditEvent event) {
        Profil person = (Profil) event.getObject();
        profilService.modifyProfil(person);
    }

    /**
     *
     * @return
     */
    public List<Profil> getProfils() {
        return profils;
    }

    /**
     *
     * @param profils
     */
    public void setProfils(List<Profil> profils) {
        this.profils = profils;
    }

    /**
     *
     * @return
     */
    public Profil getSelectedProfil() {
        return selectedProfil;
    }

    /**
     *
     * @param selectedProfil
     */
    public void setSelectedProfil(Profil selectedProfil) {
        this.selectedProfil = selectedProfil;
    }

    /**
     *
     */
    public void restartSelectedProfil() {
        this.selectedProfil = new Profil();
    }

    /**
     *
     */
    public void addProfil() {
        profilService.addProfil(this.selectedProfil);
        //We also add it to the view (refresh the Model)
        this.profils.add(this.selectedProfil);
        this.selectedProfil = null;
    }
    
    /**
     *
     */
    public void editUser() {
        profilService.modifyProfil(this.selectedProfil);
    }

    /**
     *
     */
    public void deleteProfil() {
        profilService.deleteProfil(this.selectedProfil);
        //We also eliminate it from the view (refresh the Model)
        profils.remove(this.selectedProfil);
        this.selectedProfil = null;
    }
    
}
