/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.EtudiantPromo;
import com.essa.deliberation.service.EtudiantPromoService;
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
@Named(value = "etudiantPromo")
@RequestScoped
public class EtudiantPromoBean {

    @Inject
    private EtudiantPromoService etudiantPromoService;

    private EtudiantPromo selectedEtudiantPromo;

    List<EtudiantPromo> etudiantPromos;

    public EtudiantPromoBean() {
        System.out.println("Starting ManagedBean EtudiantPromoBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        etudiantPromos = etudiantPromoService.listEtudiantPromos();
        selectedEtudiantPromo = new EtudiantPromo();
    }

    public void editListener(RowEditEvent event) {
        EtudiantPromo etudiantPromo = (EtudiantPromo) event.getObject();
        etudiantPromoService.modifyEtudiantPromo(etudiantPromo);
    }

    public List<EtudiantPromo> getEtudiantPromos() {
        return etudiantPromos;
    }

    public void setEtudiantPromos(List<EtudiantPromo> etudiantPromos) {
        this.etudiantPromos = etudiantPromos;
    }

    public EtudiantPromo getSelectedEtudiantPromo() {
        return selectedEtudiantPromo;
    }

    public void setSelectedEtudiantPromo(EtudiantPromo selectedEtudiantPromo) {
        this.selectedEtudiantPromo = selectedEtudiantPromo;
    }

    public void restartSelectedEtudiantPromo() {
        this.selectedEtudiantPromo = new EtudiantPromo();
    }

    public void addEtudiantPromo() {
        etudiantPromoService.addEtudiantPromo(this.selectedEtudiantPromo);
        //We also add it to the view (refresh the Model)
        this.etudiantPromos.add(this.selectedEtudiantPromo);
        this.selectedEtudiantPromo = null;
    }
    
    public void editEtudiantPromo() {
        etudiantPromoService.modifyEtudiantPromo(this.selectedEtudiantPromo);
    }

    public void deleteEtudiantPromo() {
        etudiantPromoService.deleteEtudiantPromo(this.selectedEtudiantPromo);
        //We also eliminate it from the view (refresh the Model)
        etudiantPromos.remove(this.selectedEtudiantPromo);
        this.selectedEtudiantPromo = null;
    }
    
}
