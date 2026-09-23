package br.edu.sistemamatricula.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Builder;

@Entity
@Table(name = "disciplinas")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Disciplina {
    @Id
    @Column(name = "codigo", nullable = false, length = 30)
    private String codigo;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "creditos", nullable = false)
    private int creditos;

    @OneToMany(mappedBy = "disciplina")
    @Builder.Default
    private List<Turma> turmas = new ArrayList<>();

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public int getCreditos() { return creditos; }
    public List<Turma> getTurmas() { return Collections.unmodifiableList(turmas); }
}
