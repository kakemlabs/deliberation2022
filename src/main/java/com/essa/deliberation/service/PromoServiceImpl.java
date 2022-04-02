/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.data.PromoDao;
import com.essa.deliberation.domain.Promo;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("promoService")
@Transactional
public class PromoServiceImpl implements PromoService {
    @Inject
    private PromoDao promoDao;

    @Override
    public List<Promo> listPromos() {
        return promoDao.findAllPromo();
    }

    @Override
    public Promo findPromo(Promo promo) {
        return promoDao.findPromoById(promo.getIdpromo());
    }

    @Override
    public void addPromo(Promo promo) {
        promoDao.insertPromo(promo);
    }

    @Override
    public void modifyPromo(Promo promo) {
        promoDao.updatePromo(promo);
    }

    @Override
    public void deletePromo(Promo promo) {
        promoDao.deletePromo(promo);
    }
}
