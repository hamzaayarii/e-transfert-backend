package com.bank.userservice.services;

import com.bank.userservice.entities.Utilisateur;
import com.bank.userservice.repositories.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisateurService implements IUtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur create(Utilisateur u) {
        return utilisateurRepository.save(u);
    }

    @Override
    public Utilisateur update(Long id, Utilisateur u) {
        Utilisateur existing = utilisateurRepository.findById(id).orElseThrow();
        existing.setNom(u.getNom());
        existing.setPrenom(u.getPrenom());
        existing.setEmail(u.getEmail());
        existing.setMotDePasse(u.getMotDePasse());
        existing.setRole(u.getRole());
        return utilisateurRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public List<Utilisateur> getAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getById(Long id) {
        return utilisateurRepository.findById(id).orElseThrow();
    }
}
