/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Profil;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface ProfilDao {
    void insertProfil(Profil profil);

    void updateProfil(Profil profil);

    void deleteProfil(Profil profil);

    Profil findProfilById(int idProfil);

    List<Profil> findAllProfil();

    long countProfil();
}
