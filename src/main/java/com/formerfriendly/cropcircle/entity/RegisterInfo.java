package com.formerfriendly.cropcircle.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "crpcrcle_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String odid;
    private String device;
    private String build;
    private String fullName;
    private String email;
    private String mobilenumber;
    private String password;
}
