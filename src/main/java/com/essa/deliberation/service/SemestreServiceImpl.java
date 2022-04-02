/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.SemestreDao;
import com.essa.deliberation.domain.Semestre;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("semestreService")
@Transactional
public class SemestreServiceImpl implements SemestreService {
    @Inject
    private SemestreDao semestreDao;

    @Override
    public List<Semestre> listSemestres() {
        return semestreDao.findAllSemestre();
    }

    @Override
    public Semestre findSemestre(Semestre semestre) {
        return semestreDao.findSemestreById(semestre.getIdsemestre());
    }

    @Override
    public void addSemestre(Semestre semestre) {
        semestreDao.insertSemestre(semestre);
    }

    @Override
    public void modifySemestre(Semestre semestre) {
        semestreDao.updateSemestre(semestre);
    }

    @Override
    public void deleteSemestre(Semestre semestre) {
        semestreDao.deleteSemestre(semestre);
    }
}
