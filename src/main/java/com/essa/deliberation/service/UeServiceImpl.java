/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.UeDao;
import com.essa.deliberation.domain.Ue;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("ueService")
@Transactional
public class UeServiceImpl implements UeService {
    
    @Inject
    private UeDao ueDao;
    
    @Override
    public List<Ue> listUes() {
        return ueDao.findAllUe();
    }

    @Override
    public Ue findUe(Ue ue) {
        return ueDao.findUeById(ue.getIdue());
    }

    @Override
    public void addUe(Ue ue) {
        ueDao.insertUe(ue);
    }

    @Override
    public void modifyUe(Ue ue) {
        ueDao.updateUe(ue);
    }

    @Override
    public void deleteUe(Ue ue) {
        ueDao.deleteUe(ue);
    }
    
}
