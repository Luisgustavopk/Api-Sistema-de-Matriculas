package br.edu.sistemamatricula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public final class DisciplinaDto {
    private DisciplinaDto() { }

    public record Requisicao(
            @NotBlank @Size(max = 30) String codigo,
            @NotBlank @Size(max = 150) String nome,
            @Positive int creditos) { }

    public record Resposta(
            String codigo,
            String nome,
            int creditos) { }
}
