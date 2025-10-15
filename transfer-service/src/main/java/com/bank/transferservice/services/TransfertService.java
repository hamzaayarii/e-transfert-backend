package com.bank.transferservice.services;

import com.bank.transferservice.entities.Transfert;
import com.bank.transferservice.repositories.TransfertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransfertService {

    @Autowired
    private TransfertRepository transfertRepository;

    // Récupérer tous les transferts
    public List<Transfert> findAll() {
        return transfertRepository.findAll();
    }

    // Récupérer un transfert par ID
    public Transfert findById(Long id) {
        return transfertRepository.findById(id).orElse(null);
    }

    // Créer un transfert
    public Transfert save(Transfert transfert) {
        return transfertRepository.save(transfert);
    }

    // Mettre à jour un transfert
    public Transfert update(Transfert transfert) {
        if (transfert.getId() == null || !transfertRepository.existsById(transfert.getId())) {
            throw new RuntimeException("Transfert non trouvé avec l'ID : " + transfert.getId());
        }
        return transfertRepository.save(transfert);
    }

    // Supprimer un transfert
    public void delete(Long id) {
        if (!transfertRepository.existsById(id)) {
            throw new RuntimeException("Transfert non trouvé avec l'ID : " + id);
        }
        transfertRepository.deleteById(id);
    }
}
