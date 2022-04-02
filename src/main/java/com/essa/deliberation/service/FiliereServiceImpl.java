/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.FiliereDao;
import com.essa.deliberation.domain.Filiere;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("filiereService")
@Transactional
public class FiliereServiceImpl implements FiliereService {
    @Inject
    private FiliereDao filiereDao;

    @Override
    public List<Filiere> listFilieres() {
        return filiereDao.findAllFiliere();
    }

    @Override
    public Filiere findFiliere(Filiere filiere) {
        return filiereDao.findFiliereById(filiere.getIdfiliere());
    }

    @Override
    public void addFiliere(Filiere filiere) {
        filiereDao.insertFiliere(filiere);
    }

    @Override
    public void modifyFiliere(Filiere filiere) {
        filiereDao.updateFiliere(filiere);
    }

    @Override
    public void deleteFiliere(Filiere filiere) {
        filiereDao.deleteFiliere(filiere);
    }
}
