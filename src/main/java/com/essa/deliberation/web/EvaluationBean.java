/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.web;

import com.essa.deliberation.domain.Evaluation;
import com.essa.deliberation.service.EvaluationService;
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
@Named(value = "evaluationBean")
@RequestScoped
public class EvaluationBean {

    @Inject
    private EvaluationService evaluationService;

    private Evaluation selectedEvaluation;

    List<Evaluation> evaluations;

    public EvaluationBean() {
        System.out.println("Starting ManagedBean EvaluationBean");
    }

    @PostConstruct
    public void init() {
        //We start the variables
        evaluations = evaluationService.listEvaluations();
        selectedEvaluation = new Evaluation();
    }

    public void editListener(RowEditEvent event) {
        Evaluation evaluation = (Evaluation) event.getObject();
        evaluationService.modifyEvaluation(evaluation);
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Evaluation getSelectedEvaluation() {
        return selectedEvaluation;
    }

    public void setSelectedEvaluation(Evaluation selectedEvaluation) {
        this.selectedEvaluation = selectedEvaluation;
    }

    public void restartSelectedEvaluation() {
        this.selectedEvaluation = new Evaluation();
    }

    public void addEvaluation() {
        evaluationService.addEvaluation(this.selectedEvaluation);
        //We also add it to the view (refresh the Model)
        this.evaluations.add(this.selectedEvaluation);
        this.selectedEvaluation = null;
    }
    
    public void editEvaluation() {
        evaluationService.modifyEvaluation(this.selectedEvaluation);
    }

    public void deleteEvaluation() {
        evaluationService.deleteEvaluation(this.selectedEvaluation);
        //We also eliminate it from the view (refresh the Model)
        evaluations.remove(this.selectedEvaluation);
        this.selectedEvaluation = null;
    }
    
}
