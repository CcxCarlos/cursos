package com.balmes.cursos.repository;


import com.balmes.cursos.model.Estudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantRepository extends JpaRepository<Estudiant, Long> {
}
