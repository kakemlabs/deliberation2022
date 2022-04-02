/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.Ec;
import com.essa.deliberation.service.EcService;
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
@Named(value = "ecBean")
@RequestScoped
public class EcBean {

    @Inject
    private EcService ecService;

    private Ec selectedEc;

    List<Ec> ecs;

    public EcBean() {
        System.out.println("Starting ManagedBean EcBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        ecs = ecService.listEcs();
        selectedEc = new Ec();
    }

    public void editListener(RowEditEvent event) {
        Ec ec = (Ec) event.getObject();
        ecService.modifyEc(ec);
    }

    public List<Ec> getEcs() {
        return ecs;
    }

    public void setEcs(List<Ec> ecs) {
        this.ecs = ecs;
    }

    public Ec getSelectedEc() {
        return selectedEc;
    }

    public void setSelectedEc(Ec selectedEc) {
        this.selectedEc = selectedEc;
    }

    public void restartSelectedEc() {
        this.selectedEc = new Ec();
    }

    public void addEc() {
        ecService.addEc(this.selectedEc);
        //We also add it to the view (refresh the Model)
        this.ecs.add(this.selectedEc);
        this.selectedEc = null;
    }
    
    public void editEc() {
        ecService.modifyEc(this.selectedEc);
    }

    public void deleteEc() {
        ecService.deleteEc(this.selectedEc);
        //We also eliminate it from the view (refresh the Model)
        ecs.remove(this.selectedEc);
        this.selectedEc = null;
    }
    
}
