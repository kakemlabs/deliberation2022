/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.MoyenneEc;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface MoyenneEcService {
    public List<MoyenneEc> listMoyenneEcs();

    public MoyenneEc findMoyenneEc(MoyenneEc moyenneEc);

    public void addMoyenneEc(MoyenneEc moyenneEc);

    public void modifyMoyenneEc(MoyenneEc moyenneEc);

    public void deleteMoyenneEc(MoyenneEc moyenneEc);
}
