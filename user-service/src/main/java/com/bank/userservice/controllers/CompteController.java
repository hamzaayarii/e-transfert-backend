package com.bank.userservice.controllers;

import com.bank.userservice.entities.Compte;
import com.bank.userservice.services.ICompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comptes")
public class CompteController {

    @Autowired
    private ICompteService compteService;

    @PostMapping
    public ResponseEntity<Compte> createCompte(@RequestBody Compte compte) {
        return ResponseEntity.ok(compteService.save(compte));
    }

    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<List<Compte>> getComptesByUtilisateur(@PathVariable Long id) {
        return ResponseEntity.ok(compteService.findByUtilisateurId(id));
    }
}