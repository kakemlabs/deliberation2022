/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.MoyenneUeDao;
import com.essa.deliberation.domain.MoyenneUe;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("moyenneUeService")
@Transactional
public class MoyenneUeServiceImpl implements MoyenneUeService {
    @Inject
    private MoyenneUeDao moyenneUeDao;

    @Override
    public List<MoyenneUe> listMoyenneUes() {
        return moyenneUeDao.findAllMoyenneUe();
    }

    @Override
    public MoyenneUe findMoyenneUe(MoyenneUe moyenneUe) {
        return moyenneUeDao.findMoyenneUeById(moyenneUe.getIdmue());
    }

    @Override
    public void addMoyenneUe(MoyenneUe moyenneUe) {
        moyenneUeDao.insertMoyenneUe(moyenneUe);
    }

    @Override
    public void modifyMoyenneUe(MoyenneUe moyenneUe) {
        moyenneUeDao.updateMoyenneUe(moyenneUe);
    }

    @Override
    public void deleteMoyenneUe(MoyenneUe moyenneUe) {
        moyenneUeDao.deleteMoyenneUe(moyenneUe);
    }
}
