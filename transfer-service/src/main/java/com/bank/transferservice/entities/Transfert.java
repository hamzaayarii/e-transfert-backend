package com.bank.transferservice.entities;


import com.bank.transferservice.enums.TypeVirement;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transfert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emetteurRib;
    private String beneficiaireRib;
    private double montant;
    private Date dateTransfert;

    @Enumerated(EnumType.STRING)
    private TypeVirement type;
}