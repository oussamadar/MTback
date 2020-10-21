package com.virementmultipe.demo.exception;

public class VirementMultipeExceptionResponse {
    private String virementMultipe;

    public VirementMultipeExceptionResponse(String virementMultipe) {
        this.virementMultipe = virementMultipe;
    }

    public String getVirementMultipe() {
        return virementMultipe;
    }

    public VirementMultipeExceptionResponse setVirementMultipe(String virementMultipe) {
        this.virementMultipe = virementMultipe;
        return this;
    }
}
