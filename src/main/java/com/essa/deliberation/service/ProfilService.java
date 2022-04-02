/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.Profil;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface ProfilService {
    public List<Profil> listProfils();

    public Profil findProfil(Profil profil);

    public void addProfil(Profil profil);

    public void modifyProfil(Profil profil);

    public void deleteProfil(Profil profil);
}
