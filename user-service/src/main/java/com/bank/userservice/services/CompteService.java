package com.bank.userservice.services;

import com.bank.userservice.entities.Compte;
import com.bank.userservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService implements ICompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Compte save(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public List<Compte> findByUtilisateurId(Long utilisateurId) {
        return compteRepository.findByUtilisateurId(utilisateurId);
    }
}