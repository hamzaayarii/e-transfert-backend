package com.bank.userservice.entities;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Compte {
    @Id
    private Long id;
    private String rib;
    private double solde;

    @ManyToOne
    private Utilisateur utilisateur;
}
