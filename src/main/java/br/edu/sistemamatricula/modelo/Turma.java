package br.edu.sistemamatricula.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "turmas")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Turma {
    @Id
    @Column(name = "codigo", nullable = false, length = 30)
    private String codigo;

    @Column(name = "semestre", nullable = false, length = 6)
    private String semestre;

    @Column(name = "inicio_matriculas", nullable = false)
    private LocalDate inicioMatriculas;

    @Column(name = "fim_matriculas", nullable = false)
    private LocalDate fimMatriculas;

    @Column(name = "situacao", nullable = false, length = 30)
    private String situacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "disciplina_codigo", nullable = false)
    private Disciplina disciplina;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @OneToMany(mappedBy = "turma")
    @Builder.Default
    private List<Matricula> matriculas = new ArrayList<>();

    public String getCodigo() { return codigo; }
    public String getSemestre() { return semestre; }
    public LocalDate getInicioMatriculas() { return inicioMatriculas; }
    public LocalDate getFimMatriculas() { return fimMatriculas; }
    public String getSituacao() { return situacao; }
    public Disciplina getDisciplina() { return disciplina; }
    public Professor getProfessor() { return professor; }
    public List<Matricula> getMatriculas() { return Collections.unmodifiableList(matriculas); }

   
    public boolean periodoAberto() {
        throw new UnsupportedOperationException("Verificação do período prevista para a sprint 3.");
    }

    public boolean temVaga() {
        throw new UnsupportedOperationException("Verificação de vagas prevista para a sprint 3.");
    }

    /** Atributo derivado /quantidadeAlunos do UML; não é uma coluna. */
    public int getQuantidadeAlunos() {
        throw new UnsupportedOperationException("Contagem de matrículas ativas prevista para a sprint 3.");
    }
}
