package com.virementmultipe.demo.exception;

public class BenficireNotExistExceptionResponse {
    private String beneficiare;

    public BenficireNotExistExceptionResponse(String beneficiare) {
        this.beneficiare = beneficiare;
    }

    public String getBeneficiare() {
        return beneficiare;
    }

    public BenficireNotExistExceptionResponse setBeneficiare(String beneficiare) {
        this.beneficiare = beneficiare;
        return this;
    }
}
