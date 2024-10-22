package com.sigurnost.securitytask.dto;

public class AuthResponseDTO {

    private String accessToken;
    private String tokenType = "Bearer ";

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }
}
