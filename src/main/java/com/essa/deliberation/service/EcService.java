/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.service;

import com.essa.deliberation.domain.Ec;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface EcService {
    public List<Ec> listEcs();

    public Ec findEc(Ec ec);

    public void addEc(Ec ec);

    public void modifyEc(Ec ec);

    public void deleteEc(Ec ec);
}
