package br.edu.sistemamatricula.repository;

import br.edu.sistemamatricula.modelo.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
