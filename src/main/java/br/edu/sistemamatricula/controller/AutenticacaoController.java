package br.edu.sistemamatricula.controller;

import br.edu.sistemamatricula.dto.UsuarioDto;
import br.edu.sistemamatricula.service.AutenticacaoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticacao")
public class AutenticacaoController {
    private final AutenticacaoService service;

    public AutenticacaoController(AutenticacaoService service) {
        this.service = service;
    }

    @PostMapping
    public UsuarioDto.Resposta autenticar(@Valid @RequestBody UsuarioDto.Credenciais credenciais) {
        return service.autenticar(credenciais);
    }
}
