/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.EtudiantPromo;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface EtudiantPromoDao {
    void insertEtudiantPromo(EtudiantPromo etudiantPromo);

    void updateEtudiantPromo(EtudiantPromo etudiantPromo);

    void deleteEtudiantPromo(EtudiantPromo etudiantPromo);

    EtudiantPromo findEtudiantPromoById(int idEtudiantPromo);

    List<EtudiantPromo> findAllEtudiantPromo();

    long countEtudiantPromo();
}
