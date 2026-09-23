package br.edu.sistemamatricula.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "secretarias")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Secretaria extends Usuario {
    @Column(name = "setor", nullable = false, length = 100)
    private String setor;

    @Column(name = "cargo", nullable = false, length = 100)
    private String cargo;

    public String getSetor() { return setor; }
    public String getCargo() { return cargo; }
}
