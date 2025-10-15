package com.bank.commonlib.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferDTO {
    private Long id;
    private Long fromAccount;
    private Long toAccount;
    private BigDecimal amount;
    private String status;
}
