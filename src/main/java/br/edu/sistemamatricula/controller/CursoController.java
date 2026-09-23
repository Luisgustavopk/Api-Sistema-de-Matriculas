package br.edu.sistemamatricula.controller;

import br.edu.sistemamatricula.dto.CursoDto;
import br.edu.sistemamatricula.service.CursoService;
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
@RequestMapping("/api/cursos")
public class CursoController {
    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public Page<CursoDto.Resposta> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public CursoDto.Resposta consultar(@PathVariable String id) {
        return service.consultar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDto.Resposta cadastrar(@Valid @RequestBody CursoDto.Requisicao requisicao) {
        return service.cadastrar(requisicao);
    }

    @PutMapping("/{id}")
    public CursoDto.Resposta atualizar(@PathVariable String id, @Valid @RequestBody CursoDto.Requisicao requisicao) {
        return service.atualizar(id, requisicao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable String id) {
        service.excluir(id);
    }
}
