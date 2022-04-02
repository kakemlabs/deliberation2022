/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.ProfilDao;
import com.essa.deliberation.domain.Profil;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("profilService")
@Transactional
public class ProfilServiceImpl implements ProfilService{
    @Inject
    private ProfilDao profilDao;

    @Override
    public List<Profil> listProfils() {
        return profilDao.findAllProfil();
    }

    @Override
    public Profil findProfil(Profil profil) {
        return profilDao.findProfilById(profil.getIdProfil());
    }

    @Override
    public void addProfil(Profil profil) {
        profilDao.insertProfil(profil);
    }

    @Override
    public void modifyProfil(Profil profil) {
        profilDao.updateProfil(profil);
    }

    @Override
    public void deleteProfil(Profil profil) {
        profilDao.deleteProfil(profil);
    }
}
