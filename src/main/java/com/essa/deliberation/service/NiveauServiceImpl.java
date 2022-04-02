/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.NiveauDao;
import com.essa.deliberation.domain.Niveau;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("niveauService")
@Transactional
public class NiveauServiceImpl implements NiveauService {

    @Inject
    private NiveauDao niveauDao;

    @Override
    public List<Niveau> listNiveaux() {
        return niveauDao.findAllNiveau();
    }

    @Override
    public Niveau findNiveau(Niveau niveau) {
        return niveauDao.findNiveauById(niveau.getIdniveau());
    }

    @Override
    public void addNiveau(Niveau niveau) {
        niveauDao.insertNiveau(niveau);
    }

    @Override
    public void modifyNiveau(Niveau niveau) {
        niveauDao.updateNiveau(niveau);
    }

    @Override
    public void deleteNiveau(Niveau niveau) {
        niveauDao.deleteNiveau(niveau);
    }
}
