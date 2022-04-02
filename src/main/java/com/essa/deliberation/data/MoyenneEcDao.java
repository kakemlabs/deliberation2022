/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.MoyenneEc;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface MoyenneEcDao {
    void insertMoyenneEc(MoyenneEc moyenneEc);

    void updateMoyenneEc(MoyenneEc moyenneEc);

    void deleteMoyenneEc(MoyenneEc moyenneEc);

    MoyenneEc findMoyenneEcById(int idMoyenneEc);

    List<MoyenneEc> findAllMoyenneEc();

    long countMoyenneEc();
}
