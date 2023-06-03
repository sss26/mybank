package com.smthasa.mybank.web.forms;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransactionForm {

    @NotNull
    private BigDecimal amount;

    @NotBlank
    private String reference;

    @NotBlank
    private String receivingUser;

    public String getReceivingUser() {
        return receivingUser;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReceivingUser(String receivingUser) {
        this.receivingUser = receivingUser;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
