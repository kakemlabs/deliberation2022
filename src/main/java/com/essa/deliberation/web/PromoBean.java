/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.Promo;
import com.essa.deliberation.service.PromoService;
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
@Named(value = "promoBean")
@RequestScoped
public class PromoBean {

    @Inject
    private PromoService promoService;

    private Promo selectedPromo;

    List<Promo> promos;

    public PromoBean() {
        System.out.println("Starting ManagedBean PromoBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        promos = promoService.listPromos();
        selectedPromo = new Promo();
    }

    public void editListener(RowEditEvent event) {
        Promo promo = (Promo) event.getObject();
        promoService.modifyPromo(promo);
    }

    public List<Promo> getPromos() {
        return promos;
    }

    public void setPromos(List<Promo> promos) {
        this.promos = promos;
    }

    public Promo getSelectedPromo() {
        return selectedPromo;
    }

    public void setSelectedPromo(Promo selectedPromo) {
        this.selectedPromo = selectedPromo;
    }

    public void restartSelectedPromo() {
        this.selectedPromo = new Promo();
    }

    public void addPromo() {
        promoService.addPromo(this.selectedPromo);
        //We also add it to the view (refresh the Model)
        this.promos.add(this.selectedPromo);
        this.selectedPromo = null;
    }
    
    public void editPromo() {
        promoService.modifyPromo(this.selectedPromo);
    }

    public void deletePromo() {
        promoService.deletePromo(this.selectedPromo);
        //We also eliminate it from the view (refresh the Model)
        promos.remove(this.selectedPromo);
        this.selectedPromo = null;
    }
    
}
