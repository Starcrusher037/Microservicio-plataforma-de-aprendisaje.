package com.duoc.learningplatform.autenticacion_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//hola 6
@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String instructor;

    @NotBlank
    @Column(nullable = false)
    private String duracion;

    @Min(value = 0, message = "El costo no puede ser negativo")
    @Column(nullable = false)
    private double costo;
}