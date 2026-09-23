package br.edu.sistemamatricula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import java.time.LocalDate;

public final class ProfessorDto {
    private ProfessorDto() { }

    public record Requisicao(
            @NotNull @Valid UsuarioDto.Cadastro usuario,
            @NotBlank @Size(max = 100) String titulacao,
            @NotBlank @Size(max = 150) String areaAtuacao,
            @NotNull LocalDate dataAdmissao) { }

    public record Resposta(
            Long codigoDePessoa,
            String nome,
            String email,
            String telefone,
            String login,
            String titulacao,
            String areaAtuacao,
            LocalDate dataAdmissao) { }
}
