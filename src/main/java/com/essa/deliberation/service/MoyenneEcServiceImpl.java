/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.MoyenneEcDao;
import com.essa.deliberation.domain.MoyenneEc;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("moyenneEcService")
@Transactional
public class MoyenneEcServiceImpl implements MoyenneEcService {
    @Inject
    private MoyenneEcDao moyenneEcDao;

    @Override
    public List<MoyenneEc> listMoyenneEcs() {
        return moyenneEcDao.findAllMoyenneEc();
    }

    @Override
    public MoyenneEc findMoyenneEc(MoyenneEc moyenneEc) {
        return moyenneEcDao.findMoyenneEcById(moyenneEc.getIdmec());
    }

    @Override
    public void addMoyenneEc(MoyenneEc moyenneEc) {
        moyenneEcDao.insertMoyenneEc(moyenneEc);
    }

    @Override
    public void modifyMoyenneEc(MoyenneEc moyenneEc) {
        moyenneEcDao.updateMoyenneEc(moyenneEc);
    }

    @Override
    public void deleteMoyenneEc(MoyenneEc moyenneEc) {
        moyenneEcDao.deleteMoyenneEc(moyenneEc);
    }
}
