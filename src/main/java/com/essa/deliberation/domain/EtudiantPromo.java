/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cheik
 */
@Entity
@Table(name = "ETUDIANT_PROMO")
public class EtudiantPromo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDETUDIANTP")
    private Integer idetudiantp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTANT")
    private Float montant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idetudiantp")
    private List<MoyenneUe> moyenneUeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idetudiantp")
    private List<MoyenneSe> moyenneSeList;
    @JoinColumn(name = "IDETUDIANT", referencedColumnName = "IDETUDIANT")
    @ManyToOne(optional = false)
    private Etudiant idetudiant;
    @JoinColumn(name = "IDPROMO", referencedColumnName = "IDPROMO")
    @ManyToOne(optional = false)
    private Promo idpromo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idetudiantp")
    private List<Note> noteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idetudiantp")
    private List<MoyenneEc> moyenneEcList;

    public EtudiantPromo() {
    }

    public EtudiantPromo(Integer idetudiantp) {
        this.idetudiantp = idetudiantp;
    }

    public Integer getIdetudiantp() {
        return idetudiantp;
    }

    public void setIdetudiantp(Integer idetudiantp) {
        this.idetudiantp = idetudiantp;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    @XmlTransient
    public List<MoyenneUe> getMoyenneUeList() {
        return moyenneUeList;
    }

    public void setMoyenneUeList(List<MoyenneUe> moyenneUeList) {
        this.moyenneUeList = moyenneUeList;
    }

    @XmlTransient
    public List<MoyenneSe> getMoyenneSeList() {
        return moyenneSeList;
    }

    public void setMoyenneSeList(List<MoyenneSe> moyenneSeList) {
        this.moyenneSeList = moyenneSeList;
    }

    public Etudiant getIdetudiant() {
        return idetudiant;
    }

    public void setIdetudiant(Etudiant idetudiant) {
        this.idetudiant = idetudiant;
    }

    public Promo getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(Promo idpromo) {
        this.idpromo = idpromo;
    }

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    @XmlTransient
    public List<MoyenneEc> getMoyenneEcList() {
        return moyenneEcList;
    }

    public void setMoyenneEcList(List<MoyenneEc> moyenneEcList) {
        this.moyenneEcList = moyenneEcList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idetudiantp != null ? idetudiantp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtudiantPromo)) {
            return false;
        }
        EtudiantPromo other = (EtudiantPromo) object;
        if ((this.idetudiantp == null && other.idetudiantp != null) || (this.idetudiantp != null && !this.idetudiantp.equals(other.idetudiantp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.essa.deliberation.domain.EtudiantPromo[ idetudiantp=" + idetudiantp + " ]";
    }
    
}
