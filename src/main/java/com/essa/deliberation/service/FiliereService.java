/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.Filiere;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface FiliereService {
    public List<Filiere> listFilieres();

    public Filiere findFiliere(Filiere filiere);

    public void addFiliere(Filiere filiere);

    public void modifyFiliere(Filiere filiere);

    public void deleteFiliere(Filiere filiere);
}
