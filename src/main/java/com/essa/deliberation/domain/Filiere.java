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
@Table(name = "FILIERE")
public class Filiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFILIERE")
    private Integer idfiliere;
    @Size(max = 30)
    @Column(name = "NOM")
    private String nom;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfiliere")
    private List<Niveau> niveauList;

    public Filiere() {
    }

    public Filiere(Integer idfiliere) {
        this.idfiliere = idfiliere;
    }

    public Integer getIdfiliere() {
        return idfiliere;
    }

    public void setIdfiliere(Integer idfiliere) {
        this.idfiliere = idfiliere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }

    @XmlTransient
    public List<Niveau> getNiveauList() {
        return niveauList;
    }

    public void setNiveauList(List<Niveau> niveauList) {
        this.niveauList = niveauList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfiliere != null ? idfiliere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filiere)) {
            return false;
        }
        Filiere other = (Filiere) object;
        if ((this.idfiliere == null && other.idfiliere != null) || (this.idfiliere != null && !this.idfiliere.equals(other.idfiliere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.essa.deliberation.domain.Filiere[ idfiliere=" + idfiliere + " ]";
    }
    
}
