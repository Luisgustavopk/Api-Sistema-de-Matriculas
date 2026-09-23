package br.edu.sistemamatricula.service;

import br.edu.sistemamatricula.dto.AlunoDto;
import br.edu.sistemamatricula.exception.FuncionalidadeNaoImplementadaException;
import br.edu.sistemamatricula.repository.AlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AlunoService {
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Page<AlunoDto.Resposta> listar(Pageable pageable) {
        throw new FuncionalidadeNaoImplementadaException("Listar alunos");
    }

    public AlunoDto.Resposta consultar(Long id) {
        throw new FuncionalidadeNaoImplementadaException("Consultar aluno");
    }

    @Transactional
    public AlunoDto.Resposta cadastrar(AlunoDto.Requisicao requisicao) {
        throw new FuncionalidadeNaoImplementadaException("Cadastrar aluno");
    }

    @Transactional
    public AlunoDto.Resposta atualizar(Long id, AlunoDto.Requisicao requisicao) {
        throw new FuncionalidadeNaoImplementadaException("Atualizar aluno");
    }

    @Transactional
    public void excluir(Long id) {
        throw new FuncionalidadeNaoImplementadaException("Excluir aluno");
    }
}
