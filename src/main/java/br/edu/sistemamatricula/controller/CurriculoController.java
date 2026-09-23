package br.edu.sistemamatricula.controller;

import br.edu.sistemamatricula.dto.DisciplinaDto;
import br.edu.sistemamatricula.service.CurriculoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cursos/{codigo}")
public class CurriculoController {
    private final CurriculoService service;

    public CurriculoController(CurriculoService service) {
        this.service = service;
    }

    @GetMapping("/disciplinas")
    public List<DisciplinaDto.Resposta> consultarDisciplinas(@PathVariable String codigo) {
        return service.consultarDisciplinas(codigo);
    }

    @PostMapping("/curriculos/{semestre}")
    public List<DisciplinaDto.Resposta> gerarCurriculo(@PathVariable String codigo, @PathVariable String semestre) {
        return service.gerarCurriculo(codigo, semestre);
    }

    @PutMapping("/disciplinas/{disciplinaCodigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void adicionarDisciplina(@PathVariable String codigo, @PathVariable String disciplinaCodigo) {
        service.adicionarDisciplina(codigo, disciplinaCodigo);
    }

    @DeleteMapping("/disciplinas/{disciplinaCodigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerDisciplina(@PathVariable String codigo, @PathVariable String disciplinaCodigo) {
        service.removerDisciplina(codigo, disciplinaCodigo);
    }
}
