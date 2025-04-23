package com.formerfriendly.cropcircle.dto;

public class StartupResponseDTO {
    private String message;

    public StartupResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
