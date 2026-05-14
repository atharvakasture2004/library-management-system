package com.atharva.library_management.dto.auth;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "Useranme is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    public LoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
