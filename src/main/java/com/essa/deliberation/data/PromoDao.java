/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Promo;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface PromoDao {
    void insertPromo(Promo promo);

    void updatePromo(Promo promo);

    void deletePromo(Promo promo);

    Promo findPromoById(int idPromo);

    List<Promo> findAllPromo();

    long countPromo();
}
