/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.EtudiantPromo;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface EtudiantPromoService {
    public List<EtudiantPromo> listEtudiantPromos();

    public EtudiantPromo findEtudiantPromo(EtudiantPromo etudiantPromo);

    public void addEtudiantPromo(EtudiantPromo etudiantPromo);

    public void modifyEtudiantPromo(EtudiantPromo etudiantPromo);

    public void deleteEtudiantPromo(EtudiantPromo etudiantPromo);
}
