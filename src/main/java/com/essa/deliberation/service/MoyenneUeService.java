/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.MoyenneUe;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface MoyenneUeService {
    public List<MoyenneUe> listMoyenneUes();

    public MoyenneUe findMoyenneUe(MoyenneUe moyenneUe);

    public void addMoyenneUe(MoyenneUe moyenneUe);

    public void modifyMoyenneUe(MoyenneUe moyenneUe);

    public void deleteMoyenneUe(MoyenneUe moyenneUe);
}
