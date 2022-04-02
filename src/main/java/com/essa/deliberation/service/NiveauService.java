/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.Niveau;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface NiveauService {

    public List<Niveau> listNiveaux();

    public Niveau findNiveau(Niveau niveau);

    public void addNiveau(Niveau niveau);

    public void modifyNiveau(Niveau niveau);

    public void deleteNiveau(Niveau niveau);
}
