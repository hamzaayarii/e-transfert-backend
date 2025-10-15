package com.bank.appointmentservice.controllers;

import com.bank.appointmentservice.entities.RendezVous;
import com.bank.appointmentservice.services.IRendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // <- ici, au-dessus de la classe
@RequestMapping("/rendezvous") // <- ici, au-dessus de la classe
public class RendezVousController { // corrigé le nom (optionnel)

    @Autowired
    private IRendezVousService rendezVousService;

    @PostMapping
    public ResponseEntity<RendezVous> create(@RequestBody RendezVous rendezVous) {
        RendezVous created = rendezVousService.create(rendezVous);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<RendezVous>> getAll() {
        List<RendezVous> list = rendezVousService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RendezVous> getById(@PathVariable("id") Long id) {
        RendezVous rendezVous = rendezVousService.getById(id);
        if (rendezVous == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rendezVous);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RendezVous> update(@PathVariable("id") Long id, @RequestBody RendezVous rdv) {
        RendezVous updated = rendezVousService.update(id, rdv);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        rendezVousService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
