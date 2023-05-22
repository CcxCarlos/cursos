package com.balmes.cursos.repository;


import com.balmes.cursos.model.Curs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursRepository extends JpaRepository<Curs, Long> {
}

