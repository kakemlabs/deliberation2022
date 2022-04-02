package com.essa.deliberation.service;

import com.essa.deliberation.domain.Etudiant;
import java.util.List;

/**
 *
 * @author cheik
 */
public interface EtudiantService {
    public List<Etudiant> listEtudiants();

    public Etudiant findEtudiant(Etudiant etudiant);

    public void addEtudiant(Etudiant etudiant);

    public void modifyEtudiant(Etudiant etudiant);

    public void deleteEtudiant(Etudiant etudiant);
}
