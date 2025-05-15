package com.example.mvcproducts.dto;

import java.util.Optional;

public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private String confirm;
    private String role;

    public Optional<Object> getEmail() {
        return Optional.ofNullable(email);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
