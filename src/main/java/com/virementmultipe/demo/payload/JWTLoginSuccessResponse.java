package com.virementmultipe.demo.payload;

public class JWTLoginSuccessResponse {
    private boolean success;
    private String token;

    public JWTLoginSuccessResponse(boolean success, String token) {
        this.success = success;
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public JWTLoginSuccessResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getToken() {
        return token;
    }

    public JWTLoginSuccessResponse setToken(String token) {
        this.token = token;
        return this;
    }

    @Override
    public String toString() {
        return "JWTLoginSuccessResponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                '}';
    }
}
