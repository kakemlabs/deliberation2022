package com.essa.deliberation.web;

import com.essa.deliberation.domain.Etudiant;
import com.essa.deliberation.service.EtudiantService;
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
@Named(value = "etudiantBean")
@RequestScoped
public class EtudiantBean {

    @Inject
    private EtudiantService etudiantService;

    private Etudiant selectedEtudiant;

    List<Etudiant> etudiants;

    public EtudiantBean() {
        System.out.println("Starting ManagedBean EtudiantBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        etudiants = etudiantService.listEtudiants();
        selectedEtudiant = new Etudiant();
    }

    public void editListener(RowEditEvent event) {
        Etudiant etudiant = (Etudiant) event.getObject();
        etudiantService.modifyEtudiant(etudiant);
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Etudiant getSelectedEtudiant() {
        return selectedEtudiant;
    }

    public void setSelectedEtudiant(Etudiant selectedEtudiant) {
        this.selectedEtudiant = selectedEtudiant;
    }

    public void restartSelectedEtudiant() {
        this.selectedEtudiant = new Etudiant();
    }

    public void addEtudiant() {
        etudiantService.addEtudiant(this.selectedEtudiant);
        //We also add it to the view (refresh the Model)
        this.etudiants.add(this.selectedEtudiant);
        this.selectedEtudiant = null;
    }
    
    public void editEtudiant() {
        etudiantService.modifyEtudiant(this.selectedEtudiant);
    }

    public void deleteEtudiant() {
        etudiantService.deleteEtudiant(this.selectedEtudiant);
        //We also eliminate it from the view (refresh the Model)
        etudiants.remove(this.selectedEtudiant);
        this.selectedEtudiant = null;
    }
    
}
