package com.duoc.learningplatform.autenticacion_service.service;

import com.duoc.learningplatform.autenticacion_service.dto.CursoDTO;
import com.duoc.learningplatform.autenticacion_service.model.Curso;
import com.duoc.learningplatform.autenticacion_service.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDTO> listarCursos() {

        return cursoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public CursoDTO guardarCurso(CursoDTO cursoDTO) {

        Curso curso = new Curso();

        curso.setNombre(cursoDTO.getNombre());
        curso.setInstructor(cursoDTO.getInstructor());
        curso.setDuracion(cursoDTO.getDuracion());
        curso.setCosto(cursoDTO.getCosto());

        Curso cursoGuardado = cursoRepository.save(curso);

        return convertirADTO(cursoGuardado);
    }

    private CursoDTO convertirADTO(Curso curso) {

        return new CursoDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getInstructor(),
                curso.getDuracion(),
                curso.getCosto()
        );
    }
}