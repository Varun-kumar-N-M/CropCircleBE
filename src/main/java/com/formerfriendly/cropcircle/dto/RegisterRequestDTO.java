package com.formerfriendly.cropcircle.dto;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
    private String odid;
    private String device;
    private String build;
    private String fullName;
    private String email;
    private String mobilenumber;
    private String password;  
}
