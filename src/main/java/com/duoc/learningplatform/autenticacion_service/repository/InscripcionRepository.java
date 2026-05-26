package com.duoc.learningplatform.autenticacion_service.repository;

import com.duoc.learningplatform.autenticacion_service.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}