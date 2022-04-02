/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Niveau;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface NiveauDao {
    void insertNiveau(Niveau niveau);

    void updateNiveau(Niveau niveau);

    void deleteNiveau(Niveau niveau);

    Niveau findNiveauById(int idNiveau);

    List<Niveau> findAllNiveau();

    long countNiveau();
}
