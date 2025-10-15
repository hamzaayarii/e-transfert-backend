package com.bank.userservice.services;

import com.bank.userservice.entities.Compte;

import java.util.List;

public interface ICompteService {
    Compte save(Compte compte);
    List<Compte> findByUtilisateurId(Long utilisateurId);
}