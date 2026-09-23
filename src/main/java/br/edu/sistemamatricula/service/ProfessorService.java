package br.edu.sistemamatricula.service;

import br.edu.sistemamatricula.dto.ProfessorDto;
import br.edu.sistemamatricula.exception.FuncionalidadeNaoImplementadaException;
import br.edu.sistemamatricula.repository.ProfessorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProfessorService {
    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public Page<ProfessorDto.Resposta> listar(Pageable pageable) {
        throw new FuncionalidadeNaoImplementadaException("Listar professores");
    }

    public ProfessorDto.Resposta consultar(Long id) {
        throw new FuncionalidadeNaoImplementadaException("Consultar professor");
    }

    @Transactional
    public ProfessorDto.Resposta cadastrar(ProfessorDto.Requisicao requisicao) {
        throw new FuncionalidadeNaoImplementadaException("Cadastrar professor");
    }

    @Transactional
    public ProfessorDto.Resposta atualizar(Long id, ProfessorDto.Requisicao requisicao) {
        throw new FuncionalidadeNaoImplementadaException("Atualizar professor");
    }

    @Transactional
    public void excluir(Long id) {
        throw new FuncionalidadeNaoImplementadaException("Excluir professor");
    }
}
