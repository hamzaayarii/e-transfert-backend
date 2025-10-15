// Interface IRendezVousService.java
package com.bank.appointmentservice.services;

import com.bank.appointmentservice.entities.RendezVous;

import java.util.List;

public interface IRendezVousService {
    RendezVous create(RendezVous rendezVous);

    List<RendezVous> getAll();

    RendezVous getById(Long id);

    RendezVous update(Long id, RendezVous rdv);

    void delete(Long id);
}
