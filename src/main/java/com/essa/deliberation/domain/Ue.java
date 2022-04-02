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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cheik
 */
@Entity
@Table(name = "UE")
public class Ue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUE")
    private Integer idue;
    @Column(name = "CODE")
    private Integer code;
    @Size(max = 30)
    @Column(name = "NOM")
    private String nom;
    @Column(name = "CREDIT")
    private Integer credit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idue")
    private List<MoyenneUe> moyenneUeList;
    @JoinColumn(name = "IDPROMO", referencedColumnName = "IDPROMO")
    @ManyToOne(optional = false)
    private Promo idpromo;
    @JoinColumn(name = "IDSEMESTRE", referencedColumnName = "IDSEMESTRE")
    @ManyToOne(optional = false)
    private Semestre idsemestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idue")
    private List<Ec> ecList;

    public Ue() {
    }

    public Ue(Integer idue) {
        this.idue = idue;
    }

    public Integer getIdue() {
        return idue;
    }

    public void setIdue(Integer idue) {
        this.idue = idue;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @XmlTransient
    public List<MoyenneUe> getMoyenneUeList() {
        return moyenneUeList;
    }

    public void setMoyenneUeList(List<MoyenneUe> moyenneUeList) {
        this.moyenneUeList = moyenneUeList;
    }

    public Promo getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(Promo idpromo) {
        this.idpromo = idpromo;
    }

    public Semestre getIdsemestre() {
        return idsemestre;
    }

    public void setIdsemestre(Semestre idsemestre) {
        this.idsemestre = idsemestre;
    }

    @XmlTransient
    public List<Ec> getEcList() {
        return ecList;
    }

    public void setEcList(List<Ec> ecList) {
        this.ecList = ecList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idue != null ? idue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ue)) {
            return false;
        }
        Ue other = (Ue) object;
        if ((this.idue == null && other.idue != null) || (this.idue != null && !this.idue.equals(other.idue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}
