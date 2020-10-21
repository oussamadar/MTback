package com.virementmultipe.demo.exception;

public class PassswordValidationExceptionResponse {
    private String password ;

    public PassswordValidationExceptionResponse(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public PassswordValidationExceptionResponse setPassword(String password) {
        this.password = password;
        return this;
    }
}
