package com.duoc.learningplatform.autenticacion_service.controller;

import com.duoc.learningplatform.autenticacion_service.dto.InscripcionRequestDTO;
import com.duoc.learningplatform.autenticacion_service.dto.InscripcionResponseDTO;
import com.duoc.learningplatform.autenticacion_service.service.InscripcionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping
    public ResponseEntity<InscripcionResponseDTO> realizarInscripcion(
            @Valid @RequestBody InscripcionRequestDTO requestDTO) {

        InscripcionResponseDTO response =
                inscripcionService.realizarInscripcion(requestDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}