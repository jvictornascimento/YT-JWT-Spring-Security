package com.example.jwt.JwtTest.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
@Entity
@Table(name = "TB_PRODUSCTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Product extends RepresentationModel<Product> implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ToString.Include
    private String name;

    @Column(columnDefinition = "TEXT")
    @ToString.Include
    private String description;

    @ToString.Include
    private Double price;

    @ToString.Include
    private Integer quantity;
}
