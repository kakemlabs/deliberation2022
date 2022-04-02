/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author cheik
 */
@Entity
@Table(name = "NOTE")
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDNOTE")
    private Integer idnote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALEUR")
    private Float valeur;
    @JoinColumn(name = "IDETUDIANTP", referencedColumnName = "IDETUDIANTP")
    @ManyToOne(optional = false)
    private EtudiantPromo idetudiantp;
    @JoinColumn(name = "IDEVALUATION", referencedColumnName = "IDEVALUATION")
    @ManyToOne(optional = false)
    private Evaluation idevaluation;

    public Note() {
    }

    public Note(Integer idnote) {
        this.idnote = idnote;
    }

    public Integer getIdnote() {
        return idnote;
    }

    public void setIdnote(Integer idnote) {
        this.idnote = idnote;
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    public EtudiantPromo getIdetudiantp() {
        return idetudiantp;
    }

    public void setIdetudiantp(EtudiantPromo idetudiantp) {
        this.idetudiantp = idetudiantp;
    }

    public Evaluation getIdevaluation() {
        return idevaluation;
    }

    public void setIdevaluation(Evaluation idevaluation) {
        this.idevaluation = idevaluation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnote != null ? idnote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.idnote == null && other.idnote != null) || (this.idnote != null && !this.idnote.equals(other.idnote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.essa.deliberation.domain.Note[ idnote=" + idnote + " ]";
    }
    
}
