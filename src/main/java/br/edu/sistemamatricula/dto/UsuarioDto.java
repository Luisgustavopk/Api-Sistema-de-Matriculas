package br.edu.sistemamatricula.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public final class UsuarioDto {
    private UsuarioDto() { }

    public record Cadastro(
            @NotBlank @Size(max = 150) String nome,
            @NotBlank @Email @Size(max = 254) String email,
            @Size(max = 30) String telefone,
            @NotBlank @Size(max = 80) String login,
            @NotBlank @Size(min = 8, max = 128) String senha) {
        @Override
        public String toString() {
            return "Cadastro[credenciais omitidas]";
        }
    }

    public record Credenciais(@NotBlank @Size(max = 80) String login,
                              @NotBlank @Size(max = 128) String senha) {
        @Override
        public String toString() {
            return "Credenciais[omitidas]";
        }
    }

    public record NovaSenha(@NotBlank @Size(min = 8, max = 128) String senha) {
        @Override
        public String toString() {
            return "NovaSenha[omitida]";
        }
    }

    public record Resposta(
            Long codigoDePessoa,
            String nome,
            String login) { }
}
