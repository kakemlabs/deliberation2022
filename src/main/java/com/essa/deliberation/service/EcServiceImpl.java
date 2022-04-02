/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.EcDao;
import com.essa.deliberation.domain.Ec;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("ecService")
@Transactional
public class EcServiceImpl implements EcService {
    @Inject
    private EcDao ecDao;

    @Override
    public List<Ec> listEcs() {
        return ecDao.findAllEc();
    }

    @Override
    public Ec findEc(Ec ec) {
        return ecDao.findEcById(ec.getIdec());
    }

    @Override
    public void addEc(Ec ec) {
        ecDao.insertEc(ec);
    }

    @Override
    public void modifyEc(Ec ec) {
        ecDao.updateEc(ec);
    }

    @Override
    public void deleteEc(Ec ec) {
        ecDao.deleteEc(ec);
    }
}
