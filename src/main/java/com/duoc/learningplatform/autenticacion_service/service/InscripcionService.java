package com.duoc.learningplatform.autenticacion_service.service;

import com.duoc.learningplatform.autenticacion_service.dto.CursoDTO;
import com.duoc.learningplatform.autenticacion_service.dto.InscripcionRequestDTO;
import com.duoc.learningplatform.autenticacion_service.dto.InscripcionResponseDTO;
import com.duoc.learningplatform.autenticacion_service.model.Curso;
import com.duoc.learningplatform.autenticacion_service.model.Inscripcion;
import com.duoc.learningplatform.autenticacion_service.model.Usuario;
import com.duoc.learningplatform.autenticacion_service.repository.CursoRepository;
import com.duoc.learningplatform.autenticacion_service.repository.InscripcionRepository;
import com.duoc.learningplatform.autenticacion_service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public InscripcionResponseDTO realizarInscripcion(InscripcionRequestDTO requestDTO) {

        Usuario usuario = usuarioRepository.findById(requestDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Curso> cursos = cursoRepository.findAllById(requestDTO.getCursosIds());

        double total = cursos.stream()
                .mapToDouble(Curso::getCosto)
                .sum();

        Inscripcion inscripcion = new Inscripcion();

        inscripcion.setUsuario(usuario);
        inscripcion.setCursos(cursos);
        inscripcion.setTotalPagar(total);

        Inscripcion inscripcionGuardada = inscripcionRepository.save(inscripcion);

        List<CursoDTO> cursosDTO = cursos.stream()
                .map(curso -> new CursoDTO(
                        curso.getId(),
                        curso.getNombre(),
                        curso.getInstructor(),
                        curso.getDuracion(),
                        curso.getCosto()
                ))
                .toList();

        return new InscripcionResponseDTO(
                inscripcionGuardada.getId(),
                usuario.getNombre(),
                cursosDTO,
                total
        );
    }
}