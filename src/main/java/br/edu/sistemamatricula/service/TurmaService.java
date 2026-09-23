package br.edu.sistemamatricula.service;

import br.edu.sistemamatricula.dto.AlunoDto;
import br.edu.sistemamatricula.dto.TurmaDto;
import br.edu.sistemamatricula.exception.FuncionalidadeNaoImplementadaException;
import br.edu.sistemamatricula.repository.TurmaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TurmaService {
    private final TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public TurmaDto.Resposta ofertar(TurmaDto.Requisicao requisicao) {
        throw new FuncionalidadeNaoImplementadaException("Ofertar turma");
    }

    public TurmaDto.Resposta consultar(String codigo) {
        throw new FuncionalidadeNaoImplementadaException("Consultar turma");
    }

    public List<TurmaDto.Resposta> consultarPorProfessor(Long professorId, String semestre) {
        throw new FuncionalidadeNaoImplementadaException("Consultar turmas do professor");
    }

    public List<TurmaDto.Resposta> consultarPorDisciplina(String disciplinaCodigo) {
        throw new FuncionalidadeNaoImplementadaException("Consultar turmas da disciplina");
    }

    public List<TurmaDto.Resposta> consultarPorAluno(Long alunoId, String semestre) {
        throw new FuncionalidadeNaoImplementadaException("Consultar turmas do aluno");
    }

    public List<AlunoDto.Resposta> listarAlunos(String codigo) {
        throw new FuncionalidadeNaoImplementadaException("Listar alunos da turma");
    }

    @Transactional
    public void atribuirProfessor(String codigo, Long professorId) {
        throw new FuncionalidadeNaoImplementadaException("Atribuir professor");
    }

    @Transactional
    public void encerrarMatriculas(String codigo) {
        throw new FuncionalidadeNaoImplementadaException("Encerrar matrículas da turma");
    }

    @Transactional
    public void remover(String codigo) {
        throw new FuncionalidadeNaoImplementadaException("Remover turma");
    }
}
