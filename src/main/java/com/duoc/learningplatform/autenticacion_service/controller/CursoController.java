package com.duoc.learningplatform.autenticacion_service.controller;

import com.duoc.learningplatform.autenticacion_service.dto.CursoDTO;
import com.duoc.learningplatform.autenticacion_service.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listarCursos() {

        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @PostMapping
    public ResponseEntity<CursoDTO> guardarCurso(@Valid @RequestBody CursoDTO cursoDTO) {

        CursoDTO nuevoCurso = cursoService.guardarCurso(cursoDTO);

        return new ResponseEntity<>(nuevoCurso, HttpStatus.CREATED);
    }
}