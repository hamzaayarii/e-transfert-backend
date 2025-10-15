package com.bank.userservice.controllers;


import com.bank.userservice.entities.Utilisateur;
import com.bank.userservice.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @PostMapping
    public Utilisateur create(@RequestBody Utilisateur u) {
        return utilisateurService.create(u);
    }

    @PutMapping("/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur u) {
        return utilisateurService.update(id, u);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utilisateurService.delete(id);
    }

    @GetMapping
    public List<Utilisateur> getAll() {
        return utilisateurService.getAll();
    }

    @GetMapping("/{id}")
    public Utilisateur getById(@PathVariable Long id) {
        return utilisateurService.getById(id);
    }
}
