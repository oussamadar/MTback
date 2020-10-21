package com.virementmultipe.demo.exception;

public class VirementMontantExceptionResponse {

    private String montant;

    public VirementMontantExceptionResponse(String montant) {
        this.montant = montant;
    }

    public String getMontant() {
        return montant;
    }

    public VirementMontantExceptionResponse setMontant(String montant) {
        this.montant = montant;
        return this;
    }
}
