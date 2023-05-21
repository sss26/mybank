package com.smthasa.mybank.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class TransactionDto {

    @Min(1)
    @Max(100)
    private BigDecimal amount;

    @NotBlank
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
