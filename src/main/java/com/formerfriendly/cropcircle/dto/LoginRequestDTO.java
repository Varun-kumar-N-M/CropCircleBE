package com.formerfriendly.cropcircle.dto;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    private String odid;
    private String device;
    private String build;
    private String email;
    private String mobilenumber;
    private String password;
}
