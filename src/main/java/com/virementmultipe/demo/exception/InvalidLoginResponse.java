package com.virementmultipe.demo.exception;

public class InvalidLoginResponse {
    private String username;
    private String password;

    public InvalidLoginResponse() {
        this.username = "Invalid Username";
        this.password = "Invalid Password";
    }

    public String getUsername() {
        return username;
    }

    public InvalidLoginResponse setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public InvalidLoginResponse setPassword(String password) {
        this.password = password;
        return this;
    }
}
