package com.smthasa.mybank.dto;

import java.math.BigDecimal;

public class TransactionDto {

    private BigDecimal amount;

    private String reference;

    public BigDecimal getAmount() {
        return amount;
    }

    public String getReference() {
        return reference;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
