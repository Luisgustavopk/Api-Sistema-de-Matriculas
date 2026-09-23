package br.edu.sistemamatricula.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Builder;

@Entity
@Table(name = "alunos")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Aluno extends Usuario {
    @Column(name = "data_ingresso", nullable = false)
    private LocalDate dataIngresso;

    @Column(name = "situacao_academica", nullable = false, length = 40)
    private String situacaoAcademica;

    @OneToMany(mappedBy = "aluno")
    @Builder.Default
    private List<Matricula> matriculas = new ArrayList<>();

    public LocalDate getDataIngresso() { return dataIngresso; }
    public String getSituacaoAcademica() { return situacaoAcademica; }
    public List<Matricula> getMatriculas() { return Collections.unmodifiableList(matriculas); }
}
