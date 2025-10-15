package com.bank.userservice.repositories;

import com.bank.userservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByUtilisateurId(Long utilisateurId);
}