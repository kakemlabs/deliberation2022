/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essa.deliberation.data;

import com.essa.deliberation.domain.Ue;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface UeDao {
    void insertUe(Ue ue);

    void updateUe(Ue ue);

    void deleteUe(Ue ue);

    Ue findUeById(int idUe);

    List<Ue> findAllUe();

    long countUe();
}
