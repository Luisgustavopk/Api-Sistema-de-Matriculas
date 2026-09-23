package br.edu.sistemamatricula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public final class TurmaDto {
    private TurmaDto() { }

    public record Requisicao(
            @NotBlank @Size(max = 30) String codigo,
            @NotBlank @Pattern(regexp = "[0-9]{4}-[12]") String semestre,
            @NotNull LocalDate inicioMatriculas,
            @NotNull LocalDate fimMatriculas,
            @NotBlank @Size(max = 30) String disciplinaCodigo,
            @NotNull @Positive Long professorId) { }

    public record Resposta(
            String codigo,
            String semestre,
            LocalDate inicioMatriculas,
            LocalDate fimMatriculas,
            String situacao,
            String disciplinaCodigo,
            Long professorId) { }
}
