/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.EtudiantPromoDao;
import com.essa.deliberation.domain.EtudiantPromo;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("etudiantPromoService")
@Transactional
public class EtudiantPromoServiceImpl implements EtudiantPromoService {
    @Inject
    private EtudiantPromoDao etudiantPromoDao;

    @Override
    public List<EtudiantPromo> listEtudiantPromos() {
        return etudiantPromoDao.findAllEtudiantPromo();
    }

    @Override
    public EtudiantPromo findEtudiantPromo(EtudiantPromo etudiantPromo) {
        return etudiantPromoDao.findEtudiantPromoById(etudiantPromo.getIdetudiantp());
    }

    @Override
    public void addEtudiantPromo(EtudiantPromo etudiantPromo) {
        etudiantPromoDao.insertEtudiantPromo(etudiantPromo);
    }

    @Override
    public void modifyEtudiantPromo(EtudiantPromo etudiantPromo) {
        etudiantPromoDao.updateEtudiantPromo(etudiantPromo);
    }

    @Override
    public void deleteEtudiantPromo(EtudiantPromo etudiantPromo) {
        etudiantPromoDao.deleteEtudiantPromo(etudiantPromo);
    }
}
