package br.edu.sistemamatricula.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Builder;

@Entity
@Table(name = "cursos")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Curso {
    @Id
    @Column(name = "codigo", nullable = false, length = 30)
    private String codigo;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "total_creditos", nullable = false)
    private int totalCreditos;

    @ManyToMany
    @JoinTable(name = "curso_disciplinas",
        joinColumns = @JoinColumn(name = "curso_codigo"),
        inverseJoinColumns = @JoinColumn(name = "disciplina_codigo"))
    @Builder.Default
    private List<Disciplina> disciplinas = new ArrayList<>();

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public int getTotalCreditos() { return totalCreditos; }
    public List<Disciplina> getDisciplinas() { return Collections.unmodifiableList(disciplinas); }

    public void adicionarDisciplina(Disciplina disciplina) {
        throw new UnsupportedOperationException("Inclusão de disciplina prevista para a sprint 3.");
    }

    public void removerDisciplina(Disciplina disciplina) {
        throw new UnsupportedOperationException("Remoção de disciplina prevista para a sprint 3.");
    }
}

