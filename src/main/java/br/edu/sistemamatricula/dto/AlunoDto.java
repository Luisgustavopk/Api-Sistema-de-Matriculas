package br.edu.sistemamatricula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import java.time.LocalDate;

public final class AlunoDto {
    private AlunoDto() { }

    public record Requisicao(
            @NotNull @Valid UsuarioDto.Cadastro usuario,
            @NotNull LocalDate dataIngresso,
            @NotBlank @Size(max = 40) String situacaoAcademica) { }

    public record Resposta(
            Long codigoDePessoa,
            String nome,
            String email,
            String telefone,
            String login,
            LocalDate dataIngresso,
            String situacaoAcademica) { }
}
