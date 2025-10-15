package com.bank.userservice.services;


import com.bank.userservice.entities.Utilisateur;

import java.util.List;

public interface IUtilisateurService {
    Utilisateur create(Utilisateur u);
    Utilisateur update(Long id, Utilisateur u);
    void delete(Long id);
    List<Utilisateur> getAll();
    Utilisateur getById(Long id);
}
