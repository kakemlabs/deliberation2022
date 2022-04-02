/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Ec;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface EcDao {
    void insertEc(Ec ec);

    void updateEc(Ec ec);

    void deleteEc(Ec ec);

    Ec findEcById(int idEc);

    List<Ec> findAllEc();

    long countEc();
}
