/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.domain;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "MOYENNE_EC")
public class MoyenneEc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMEC")
    private Integer idmec;
    @Column(name = "VALEUR")
    private BigInteger valeur;
    @JoinColumn(name = "IDEC", referencedColumnName = "IDEC")
    @ManyToOne(optional = false)
    private Ec idec;
    @JoinColumn(name = "IDETUDIANTP", referencedColumnName = "IDETUDIANTP")
    @ManyToOne(optional = false)
    private EtudiantPromo idetudiantp;

    public MoyenneEc() {
    }

    public MoyenneEc(Integer idmec) {
        this.idmec = idmec;
    }

    public Integer getIdmec() {
        return idmec;
    }

    public void setIdmec(Integer idmec) {
        this.idmec = idmec;
    }

    public BigInteger getValeur() {
        return valeur;
    }

    public void setValeur(BigInteger valeur) {
        this.valeur = valeur;
    }

    public Ec getIdec() {
        return idec;
    }

    public void setIdec(Ec idec) {
        this.idec = idec;
    }

    public EtudiantPromo getIdetudiantp() {
        return idetudiantp;
    }

    public void setIdetudiantp(EtudiantPromo idetudiantp) {
        this.idetudiantp = idetudiantp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmec != null ? idmec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoyenneEc)) {
            return false;
        }
        MoyenneEc other = (MoyenneEc) object;
        if ((this.idmec == null && other.idmec != null) || (this.idmec != null && !this.idmec.equals(other.idmec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.essa.deliberation.domain.MoyenneEc[ idmec=" + idmec + " ]";
    }
    
}
