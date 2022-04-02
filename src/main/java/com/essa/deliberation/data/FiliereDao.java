/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Filiere;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface FiliereDao {
    void insertFiliere(Filiere filiere);

    void updateFiliere(Filiere filiere);

    void deleteFiliere(Filiere filiere);

    Filiere findFiliereById(int idFiliere);

    List<Filiere> findAllFiliere();

    long countFiliere();
}
