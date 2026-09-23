package br.edu.sistemamatricula.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "matriculas", uniqueConstraints = @UniqueConstraint(name = "uk_matricula_aluno_turma", columnNames = {"aluno_id", "turma_codigo"}))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "optativa", nullable = false)
    private boolean optativa;

    @Column(name = "situacao", nullable = false, length = 30)
    private String situacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "turma_codigo", nullable = false)
    private Turma turma;

    public Long getId() { return id; }
    public LocalDate getData() { return data; }
    public boolean isOptativa() { return optativa; }
    public String getSituacao() { return situacao; }
    public Aluno getAluno() { return aluno; }
    public Turma getTurma() { return turma; }

    public boolean estaAtiva() {
        throw new UnsupportedOperationException("Verificação de matrícula prevista para a sprint 3.");
    }
}
