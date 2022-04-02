package com.essa.deliberation.data;

import com.essa.deliberation.domain.Etudiant;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface EtudiantDao {
    void insertEtudiant(Etudiant etudiant);

    void updateEtudiant(Etudiant etudiant);

    void deleteEtudiant(Etudiant etudiant);

    Etudiant findEtudiantById(int idEtudiant);

    List<Etudiant> findAllEtudiant();

    long countEtudiant();
}
