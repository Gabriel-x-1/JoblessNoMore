package com.example.mvcproducts.dto;

public class LoginResponse {
    private String token;
    private String userType;
    private String username;

    public LoginResponse(String token, String userType, String username) {
        this.token = token;
        this.userType = userType;
        this.username = username;
    }

    // Getters and setters
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
