package br.edu.sistemamatricula.service;

import br.edu.sistemamatricula.dto.CursoDto;
import br.edu.sistemamatricula.exception.FuncionalidadeNaoImplementadaException;
import br.edu.sistemamatricula.repository.CursoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CursoService {
    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public Page<CursoDto.Resposta> listar(Pageable pageable) {
        throw new FuncionalidadeNaoImplementadaException("Listar cursos");
    }

    public CursoDto.Resposta consultar(String id) {
        throw new FuncionalidadeNaoImplementadaException("Consultar curso");
    }

    @Transactional
    public CursoDto.Resposta cadastrar(CursoDto.Requisicao requisicao) {
        throw new FuncionalidadeNaoImplementadaException("Cadastrar curso");
    }

    @Transactional
    public CursoDto.Resposta atualizar(String id, CursoDto.Requisicao requisicao) {
        throw new FuncionalidadeNaoImplementadaException("Atualizar curso");
    }

    @Transactional
    public void excluir(String id) {
        throw new FuncionalidadeNaoImplementadaException("Excluir curso");
    }
}
