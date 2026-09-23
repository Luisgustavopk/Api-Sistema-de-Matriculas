package br.edu.sistemamatricula.repository;

import br.edu.sistemamatricula.modelo.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, String> {
}
