package com.bank.transferservice.repositories;


import com.bank.transferservice.entities.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransfertRepository extends JpaRepository<Transfert, Long> {
}