package com.duoc.learningplatform.autenticacion_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionRequestDTO {

    private Long usuarioId;
    private List<Long> cursosIds;
}