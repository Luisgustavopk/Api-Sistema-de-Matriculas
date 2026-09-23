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
@Table(name = "professores")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Professor extends Usuario {
    @Column(name = "titulacao", nullable = false, length = 100)
    private String titulacao;

    @Column(name = "area_atuacao", nullable = false, length = 150)
    private String areaAtuacao;

    @Column(name = "data_admissao", nullable = false)
    private LocalDate dataAdmissao;

    @OneToMany(mappedBy = "professor")
    @Builder.Default
    private List<Turma> turmas = new ArrayList<>();

    public String getTitulacao() { return titulacao; }
    public String getAreaAtuacao() { return areaAtuacao; }
    public LocalDate getDataAdmissao() { return dataAdmissao; }
    public List<Turma> getTurmas() { return Collections.unmodifiableList(turmas); }
}
