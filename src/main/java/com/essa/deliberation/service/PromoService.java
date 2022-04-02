/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.Promo;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface PromoService {
    public List<Promo> listPromos();

    public Promo findPromo(Promo promo);

    public void addPromo(Promo promo);

    public void modifyPromo(Promo promo);

    public void deletePromo(Promo promo);
}
