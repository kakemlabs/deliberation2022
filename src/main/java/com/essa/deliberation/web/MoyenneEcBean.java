/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.MoyenneEc;
import com.essa.deliberation.service.MoyenneEcService;
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
@Named(value = "moyenneEcBean")
@RequestScoped
public class MoyenneEcBean {

    @Inject
    private MoyenneEcService moyenneEcService;

    private MoyenneEc selectedMoyenneEc;

    List<MoyenneEc> moyenneEcs;

    public MoyenneEcBean() {
        System.out.println("Starting ManagedBean MoyenneEcBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        moyenneEcs = moyenneEcService.listMoyenneEcs();
        selectedMoyenneEc = new MoyenneEc();
    }

    public void editListener(RowEditEvent event) {
        MoyenneEc moyenneEc = (MoyenneEc) event.getObject();
        moyenneEcService.modifyMoyenneEc(moyenneEc);
    }

    public List<MoyenneEc> getMoyenneEcs() {
        return moyenneEcs;
    }

    public void setMoyenneEcs(List<MoyenneEc> moyenneEcs) {
        this.moyenneEcs = moyenneEcs;
    }

    public MoyenneEc getSelectedMoyenneEc() {
        return selectedMoyenneEc;
    }

    public void setSelectedMoyenneEc(MoyenneEc selectedMoyenneEc) {
        this.selectedMoyenneEc = selectedMoyenneEc;
    }

    public void restartSelectedMoyenneEc() {
        this.selectedMoyenneEc = new MoyenneEc();
    }

    public void addMoyenneEc() {
        moyenneEcService.addMoyenneEc(this.selectedMoyenneEc);
        //We also add it to the view (refresh the Model)
        this.moyenneEcs.add(this.selectedMoyenneEc);
        this.selectedMoyenneEc = null;
    }
    
    public void editMoyenneEc() {
        moyenneEcService.modifyMoyenneEc(this.selectedMoyenneEc);
    }

    public void deleteMoyenneEc() {
        moyenneEcService.deleteMoyenneEc(this.selectedMoyenneEc);
        //We also eliminate it from the view (refresh the Model)
        moyenneEcs.remove(this.selectedMoyenneEc);
        this.selectedMoyenneEc = null;
    }
    
}
