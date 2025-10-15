package com.bank.transferservice.controllers;

import com.bank.transferservice.entities.Transfert;
import com.bank.transferservice.services.TransfertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferts")
public class TransfertController {

    @Autowired
    private TransfertService transfertService;

    @GetMapping
    public List<Transfert> getAll() {
        return transfertService.findAll();
    }

    @GetMapping("/{id}")
    public Transfert getById(@PathVariable("id") Long id) {
        return transfertService.findById(id);
    }

    @PostMapping
    public Transfert save(@RequestBody Transfert transfert) {
        return transfertService.save(transfert);
    }

    @PutMapping("/{id}")
    public Transfert update(@PathVariable("id") Long id, @RequestBody Transfert transfert) {
        transfert.setId(id);
        return transfertService.update(transfert);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        transfertService.delete(id);
    }
}
