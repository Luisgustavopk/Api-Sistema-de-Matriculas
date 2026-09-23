package br.edu.sistemamatricula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.List;

public final class CursoDto {
    private CursoDto() { }

    public record Requisicao(
            @NotBlank @Size(max = 30) String codigo,
            @NotBlank @Size(max = 150) String nome,
            @Positive int totalCreditos,
            @NotEmpty List<@NotBlank @Size(max = 30) String> disciplinas) { }

    public record Resposta(
            String codigo,
            String nome,
            int totalCreditos,
            List<String> disciplinas) { }
}
