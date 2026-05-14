package com.atharva.library_management.dto;

public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String gettoken() {
        return token;
    }

    public void settoken(String token) {
        this.token = token;
    }

}
