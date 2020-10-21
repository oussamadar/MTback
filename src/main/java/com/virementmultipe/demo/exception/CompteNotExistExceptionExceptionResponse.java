package com.virementmultipe.demo.exception;

public class CompteNotExistExceptionExceptionResponse {
    private String numeroDeCompte ;


    public CompteNotExistExceptionExceptionResponse(String numeroDeCompte) {
        this.numeroDeCompte = numeroDeCompte;
    }

    public String getNumeroDeCompte() {
        return numeroDeCompte;
    }

    public CompteNotExistExceptionExceptionResponse setNumeroDeCompte(String numeroDeCompte) {
        this.numeroDeCompte = numeroDeCompte;
        return this;
    }
}
