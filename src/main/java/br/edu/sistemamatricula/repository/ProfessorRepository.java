package br.edu.sistemamatricula.repository;

import br.edu.sistemamatricula.modelo.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
