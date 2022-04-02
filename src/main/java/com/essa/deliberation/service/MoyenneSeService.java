/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.MoyenneSe;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface MoyenneSeService {
    public List<MoyenneSe> listMoyenneSes();

    public MoyenneSe findMoyenneSe(MoyenneSe moyenneSe);

    public void addMoyenneSe(MoyenneSe moyenneSe);

    public void modifyMoyenneSe(MoyenneSe moyenneSe);

    public void deleteMoyenneSe(MoyenneSe moyenneSe);
}
