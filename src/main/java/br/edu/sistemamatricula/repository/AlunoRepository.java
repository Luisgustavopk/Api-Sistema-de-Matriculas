package br.edu.sistemamatricula.repository;

import br.edu.sistemamatricula.modelo.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
