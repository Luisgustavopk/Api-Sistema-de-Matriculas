package br.edu.sistemamatricula.service;

import br.edu.sistemamatricula.dto.DisciplinaDto;
import br.edu.sistemamatricula.exception.FuncionalidadeNaoImplementadaException;
import br.edu.sistemamatricula.repository.DisciplinaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DisciplinaService {
    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public Page<DisciplinaDto.Resposta> listar(Pageable pageable) {
        throw new FuncionalidadeNaoImplementadaException("Listar disciplinas");
    }

    public DisciplinaDto.Resposta consultar(String id) {
        throw new FuncionalidadeNaoImplementadaException("Consultar disciplina");
    }

    @Transactional
    public DisciplinaDto.Resposta cadastrar(DisciplinaDto.Requisicao requisicao) {
        throw new FuncionalidadeNaoImplementadaException("Cadastrar disciplina");
    }

    @Transactional
    public DisciplinaDto.Resposta atualizar(String id, DisciplinaDto.Requisicao requisicao) {
        throw new FuncionalidadeNaoImplementadaException("Atualizar disciplina");
    }

    @Transactional
    public void excluir(String id) {
        throw new FuncionalidadeNaoImplementadaException("Excluir disciplina");
    }
}
