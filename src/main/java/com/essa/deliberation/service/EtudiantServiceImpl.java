package com.essa.deliberation.service;

import com.essa.deliberation.data.EtudiantDao;
import com.essa.deliberation.domain.Etudiant;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author cheik
 */
@Service("etudiantService")
@Transactional
public class EtudiantServiceImpl implements EtudiantService {
    @Inject
    private EtudiantDao etudiantDao;

    @Override
    public List<Etudiant> listEtudiants() {
        return etudiantDao.findAllEtudiant();
    }

    @Override
    public Etudiant findEtudiant(Etudiant etudiant) {
        return etudiantDao.findEtudiantById(etudiant.getIdetudiant());
    }

    @Override
    public void addEtudiant(Etudiant etudiant) {
        etudiantDao.insertEtudiant(etudiant);
    }

    @Override
    public void modifyEtudiant(Etudiant etudiant) {
        etudiantDao.updateEtudiant(etudiant);
    }

    @Override
    public void deleteEtudiant(Etudiant etudiant) {
        etudiantDao.deleteEtudiant(etudiant);
    }
}
