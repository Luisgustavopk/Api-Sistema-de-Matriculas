package br.edu.sistemamatricula.controller;

import br.edu.sistemamatricula.dto.AlunoDto;
import br.edu.sistemamatricula.dto.TurmaDto;
import br.edu.sistemamatricula.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {
    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TurmaDto.Resposta ofertar(@Valid @RequestBody TurmaDto.Requisicao requisicao) {
        return service.ofertar(requisicao);
    }

    @GetMapping("/{codigo}")
    public TurmaDto.Resposta consultar(@PathVariable String codigo) {
        return service.consultar(codigo);
    }

    @GetMapping("/{codigo}/alunos")
    public List<AlunoDto.Resposta> listarAlunos(@PathVariable String codigo) {
        return service.listarAlunos(codigo);
    }

    @PutMapping("/{codigo}/professor/{professorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atribuirProfessor(@PathVariable String codigo, @PathVariable Long professorId) {
        service.atribuirProfessor(codigo, professorId);
    }

    @PostMapping("/{codigo}/encerramento")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void encerrarMatriculas(@PathVariable String codigo) {
        service.encerrarMatriculas(codigo);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String codigo) {
        service.remover(codigo);
    }
}
