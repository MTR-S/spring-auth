package com.br.myauth.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "login_attempts")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class LoginAttemptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private boolean status;

    private LocalDateTime createdAt;

    public LoginAttemptEntity(String email, boolean status, LocalDateTime createdAt) {
        this.email = email;
        this.status = status;
        this.createdAt = createdAt;
    }
}
