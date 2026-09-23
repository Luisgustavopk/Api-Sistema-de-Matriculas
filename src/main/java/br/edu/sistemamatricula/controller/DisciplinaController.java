package br.edu.sistemamatricula.controller;

import br.edu.sistemamatricula.dto.DisciplinaDto;
import br.edu.sistemamatricula.service.DisciplinaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {
    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @GetMapping
    public Page<DisciplinaDto.Resposta> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public DisciplinaDto.Resposta consultar(@PathVariable String id) {
        return service.consultar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DisciplinaDto.Resposta cadastrar(@Valid @RequestBody DisciplinaDto.Requisicao requisicao) {
        return service.cadastrar(requisicao);
    }

    @PutMapping("/{id}")
    public DisciplinaDto.Resposta atualizar(@PathVariable String id, @Valid @RequestBody DisciplinaDto.Requisicao requisicao) {
        return service.atualizar(id, requisicao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable String id) {
        service.excluir(id);
    }
}
