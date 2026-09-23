package br.edu.sistemamatricula.controller;

import br.edu.sistemamatricula.dto.MatriculaDto;
import br.edu.sistemamatricula.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatriculaDto.Resposta matricular(@Valid @RequestBody MatriculaDto.Requisicao requisicao) {
        return service.matricular(requisicao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelar(@PathVariable Long id) {
        service.cancelar(id);
    }

    @GetMapping(params = {"alunoId", "semestre", "!turmaCodigo"})
    public List<MatriculaDto.Resposta> consultarPorAluno(@RequestParam Long alunoId,
                                                        @RequestParam String semestre) {
        return service.consultarPorAluno(alunoId, semestre);
    }

    @GetMapping(params = {"turmaCodigo", "!alunoId"})
    public List<MatriculaDto.Resposta> consultarPorTurma(@RequestParam String turmaCodigo) {
        return service.consultarPorTurma(turmaCodigo);
    }
}
