package com.virementmultipe.demo.exception;

public class PasswordValidationException  extends RuntimeException {
    public PasswordValidationException(String message){
        super(message);
    }
}
