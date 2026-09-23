package br.edu.sistemamatricula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public final class MatriculaDto {
    private MatriculaDto() { }

    public record Requisicao(
            @NotNull @Positive Long alunoId,
            @NotBlank @Size(max = 30) String turmaCodigo,
            boolean optativa) { }

    public record Resposta(
            Long id,
            LocalDate data,
            boolean optativa,
            String situacao,
            Long alunoId,
            String turmaCodigo) { }
}
