package com.example.jwt.JwtTest.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User implements Serializable {
    private static final long serialVersionUID=1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    @ToString.Include
    private String email;

    @ToString.Include
    private String password;

    private String role;
}
