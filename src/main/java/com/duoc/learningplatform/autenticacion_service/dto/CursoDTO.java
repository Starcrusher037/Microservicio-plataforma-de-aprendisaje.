package com.duoc.learningplatform.autenticacion_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {

    private Long id;
    private String nombre;
    private String instructor;
    private String duracion;
    private double costo;
}