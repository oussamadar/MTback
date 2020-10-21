package com.virementmultipe.demo.exception;

public class UsernameAlreadyExistsExceptionResponse  {
    private String username ;

    public UsernameAlreadyExistsExceptionResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public UsernameAlreadyExistsExceptionResponse setUsername(String username) {
        this.username = username;
        return this;
    }
}
