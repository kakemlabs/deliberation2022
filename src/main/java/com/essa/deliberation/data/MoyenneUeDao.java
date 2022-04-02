/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.MoyenneUe;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface MoyenneUeDao {
    void insertMoyenneUe(MoyenneUe moyenneUe);

    void updateMoyenneUe(MoyenneUe moyenneUe);

    void deleteMoyenneUe(MoyenneUe moyenneUe);

    MoyenneUe findMoyenneUeById(int idMoyenneUe);

    List<MoyenneUe> findAllMoyenneUe();

    long countMoyenneUe();
}
