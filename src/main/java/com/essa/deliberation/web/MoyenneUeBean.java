/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.MoyenneUe;
import com.essa.deliberation.service.MoyenneUeService;
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
@Named(value = "moyenneUeBean")
@RequestScoped
public class MoyenneUeBean {

    @Inject
    private MoyenneUeService moyenneUeService;

    private MoyenneUe selectedMoyenneUe;

    List<MoyenneUe> moyenneUes;

    public MoyenneUeBean() {
        System.out.println("Starting ManagedBean MoyenneUeBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        moyenneUes = moyenneUeService.listMoyenneUes();
        selectedMoyenneUe = new MoyenneUe();
    }

    public void editListener(RowEditEvent event) {
        MoyenneUe moyenneUe = (MoyenneUe) event.getObject();
        moyenneUeService.modifyMoyenneUe(moyenneUe);
    }

    public List<MoyenneUe> getMoyenneUes() {
        return moyenneUes;
    }

    public void setMoyenneUes(List<MoyenneUe> moyenneUes) {
        this.moyenneUes = moyenneUes;
    }

    public MoyenneUe getSelectedMoyenneUe() {
        return selectedMoyenneUe;
    }

    public void setSelectedMoyenneUe(MoyenneUe selectedMoyenneUe) {
        this.selectedMoyenneUe = selectedMoyenneUe;
    }

    public void restartSelectedMoyenneUe() {
        this.selectedMoyenneUe = new MoyenneUe();
    }

    public void addMoyenneUe() {
        moyenneUeService.addMoyenneUe(this.selectedMoyenneUe);
        //We also add it to the view (refresh the Model)
        this.moyenneUes.add(this.selectedMoyenneUe);
        this.selectedMoyenneUe = null;
    }
    
    public void editMoyenneUe() {
        moyenneUeService.modifyMoyenneUe(this.selectedMoyenneUe);
    }

    public void deleteMoyenneUe() {
        moyenneUeService.deleteMoyenneUe(this.selectedMoyenneUe);
        //We also eliminate it from the view (refresh the Model)
        moyenneUes.remove(this.selectedMoyenneUe);
        this.selectedMoyenneUe = null;
    }
    
}
