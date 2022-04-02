/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.Ue;
import com.essa.deliberation.service.UeService;
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
@Named(value = "ueBean")
@RequestScoped
public class UeBean {

    @Inject
    private UeService ueService;

    private Ue selectedUe;

    List<Ue> ues;

    public UeBean() {
        System.out.println("Starting ManagedBean UeBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        ues = ueService.listUes();
        selectedUe = new Ue();
    }

    public void editListener(RowEditEvent event) {
        Ue ue = (Ue) event.getObject();
        ueService.modifyUe(ue);
    }

    public List<Ue> getUes() {
        return ues;
    }

    public void setUes(List<Ue> ues) {
        this.ues = ues;
    }

    public Ue getSelectedUe() {
        return selectedUe;
    }

    public void setSelectedUe(Ue selectedUe) {
        this.selectedUe = selectedUe;
    }

    public void restartSelectedUe() {
        this.selectedUe = new Ue();
    }

    public void addUe() {
        ueService.addUe(this.selectedUe);
        //We also add it to the view (refresh the Model)
        this.ues.add(this.selectedUe);
        this.selectedUe = null;
    }
    
    public void editUe() {
        ueService.modifyUe(this.selectedUe);
    }

    public void deleteUe() {
        ueService.deleteUe(this.selectedUe);
        //We also eliminate it from the view (refresh the Model)
        ues.remove(this.selectedUe);
        this.selectedUe = null;
    }
    
}
