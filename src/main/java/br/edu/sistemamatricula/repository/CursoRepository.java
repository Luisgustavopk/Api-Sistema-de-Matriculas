package br.edu.sistemamatricula.repository;

import br.edu.sistemamatricula.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, String> {
}
