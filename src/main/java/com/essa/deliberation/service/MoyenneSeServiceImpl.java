/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.MoyenneSeDao;
import com.essa.deliberation.domain.MoyenneSe;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("moyenneSeService")
@Transactional
public class MoyenneSeServiceImpl implements MoyenneSeService {
    @Inject
    private MoyenneSeDao moyenneSeDao;

    @Override
    public List<MoyenneSe> listMoyenneSes() {
        return moyenneSeDao.findAllMoyenneSe();
    }

    @Override
    public MoyenneSe findMoyenneSe(MoyenneSe moyenneSe) {
        return moyenneSeDao.findMoyenneSeById(moyenneSe.getIdmse());
    }

    @Override
    public void addMoyenneSe(MoyenneSe moyenneSe) {
        moyenneSeDao.insertMoyenneSe(moyenneSe);
    }

    @Override
    public void modifyMoyenneSe(MoyenneSe moyenneSe) {
        moyenneSeDao.updateMoyenneSe(moyenneSe);
    }

    @Override
    public void deleteMoyenneSe(MoyenneSe moyenneSe) {
        moyenneSeDao.deleteMoyenneSe(moyenneSe);
    }
}
