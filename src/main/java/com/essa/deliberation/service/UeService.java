/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.Ue;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface UeService {
    public List<Ue> listUes();

    public Ue findUe(Ue ue);

    public void addUe(Ue ue);

    public void modifyUe(Ue ue);

    public void deleteUe(Ue ue);
}
