/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.Semestre;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface SemestreService {
    public List<Semestre> listSemestres();

    public Semestre findSemestre(Semestre semestre);

    public void addSemestre(Semestre semestre);

    public void modifySemestre(Semestre semestre);

    public void deleteSemestre(Semestre semestre);
}
