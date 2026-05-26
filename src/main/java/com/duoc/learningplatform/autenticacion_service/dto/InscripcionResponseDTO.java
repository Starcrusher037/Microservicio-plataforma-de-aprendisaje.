package com.duoc.learningplatform.autenticacion_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionResponseDTO {

    private Long inscripcionId;
    private String estudiante;
    private List<CursoDTO> cursos;
    private double totalPagar;
}