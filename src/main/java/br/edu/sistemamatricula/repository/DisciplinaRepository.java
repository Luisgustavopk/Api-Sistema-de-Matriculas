package br.edu.sistemamatricula.repository;

import br.edu.sistemamatricula.modelo.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {
}
