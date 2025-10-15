// Service RendezVousService.java
package com.bank.appointmentservice.services;

import com.bank.appointmentservice.entities.RendezVous;
import com.bank.appointmentservice.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousService implements IRendezVousService {

    @Autowired
    private RendezVousRepository repository;

    @Override
    public RendezVous create(RendezVous rendezVous) {
        return repository.save(rendezVous);
    }

    @Override
    public List<RendezVous> getAll() {
        return repository.findAll();
    }

    @Override
    public RendezVous getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public RendezVous update(Long id, RendezVous rdv) {
        RendezVous existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RendezVous not found with id " + id));
        existing.setObjet(rdv.getObjet());
        existing.setDateRdv(rdv.getDateRdv());
        existing.setUtilisateurId(rdv.getUtilisateurId());
        existing.setStatut(rdv.getStatut());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
