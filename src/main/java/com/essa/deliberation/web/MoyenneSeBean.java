/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.MoyenneSe;
import com.essa.deliberation.service.MoyenneSeService;
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
@Named(value = "moyenneSeBean")
@RequestScoped
public class MoyenneSeBean {

    @Inject
    private MoyenneSeService moyenneSeService;

    private MoyenneSe selectedMoyenneSe;

    List<MoyenneSe> moyenneSes;

    public MoyenneSeBean() {
        System.out.println("Starting ManagedBean MoyenneSeBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        moyenneSes = moyenneSeService.listMoyenneSes();
        selectedMoyenneSe = new MoyenneSe();
    }

    public void editListener(RowEditEvent event) {
        MoyenneSe moyenneSe = (MoyenneSe) event.getObject();
        moyenneSeService.modifyMoyenneSe(moyenneSe);
    }

    public List<MoyenneSe> getMoyenneSes() {
        return moyenneSes;
    }

    public void setMoyenneSes(List<MoyenneSe> moyenneSes) {
        this.moyenneSes = moyenneSes;
    }

    public MoyenneSe getSelectedMoyenneSe() {
        return selectedMoyenneSe;
    }

    public void setSelectedMoyenneSe(MoyenneSe selectedMoyenneSe) {
        this.selectedMoyenneSe = selectedMoyenneSe;
    }

    public void restartSelectedMoyenneSe() {
        this.selectedMoyenneSe = new MoyenneSe();
    }

    public void addMoyenneSe() {
        moyenneSeService.addMoyenneSe(this.selectedMoyenneSe);
        //We also add it to the view (refresh the Model)
        this.moyenneSes.add(this.selectedMoyenneSe);
        this.selectedMoyenneSe = null;
    }
    
    public void editMoyenneSe() {
        moyenneSeService.modifyMoyenneSe(this.selectedMoyenneSe);
    }

    public void deleteMoyenneSe() {
        moyenneSeService.deleteMoyenneSe(this.selectedMoyenneSe);
        //We also eliminate it from the view (refresh the Model)
        moyenneSes.remove(this.selectedMoyenneSe);
        this.selectedMoyenneSe = null;
    }
    
}
