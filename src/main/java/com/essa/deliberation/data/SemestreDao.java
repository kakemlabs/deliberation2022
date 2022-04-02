/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Semestre;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface SemestreDao {
    void insertSemestre(Semestre semestre);

    void updateSemestre(Semestre semestre);

    void deleteSemestre(Semestre semestre);

    Semestre findSemestreById(int idSemestre);

    List<Semestre> findAllSemestre();

    long countSemestre();
}
