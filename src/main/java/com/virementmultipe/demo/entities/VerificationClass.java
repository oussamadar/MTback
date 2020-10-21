package com.virementmultipe.demo.entities;

import javax.validation.constraints.NotBlank;

public class VerificationClass {
    @NotBlank(message = "Enter Password")
    private String verificationPass;

    public String getVerificationPass() {
        return verificationPass;
    }

    public VerificationClass setVerificationPass(String verificationPass) {
        this.verificationPass = verificationPass;
        return this;
    }
}
