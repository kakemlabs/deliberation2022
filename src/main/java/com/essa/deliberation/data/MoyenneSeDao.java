/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.MoyenneSe;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface MoyenneSeDao {
    void insertMoyenneSe(MoyenneSe moyenneSe);

    void updateMoyenneSe(MoyenneSe moyenneSe);

    void deleteMoyenneSe(MoyenneSe moyenneSe);

    MoyenneSe findMoyenneSeById(int idMoyenneSe);

    List<MoyenneSe> findAllMoyenneSe();

    long countMoyenneSe();
}
