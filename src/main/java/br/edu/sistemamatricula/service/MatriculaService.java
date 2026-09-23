package br.edu.sistemamatricula.service;

import br.edu.sistemamatricula.dto.MatriculaDto;
import br.edu.sistemamatricula.exception.FuncionalidadeNaoImplementadaException;
import br.edu.sistemamatricula.repository.MatriculaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MatriculaService {
    private final MatriculaRepository repository;

    public MatriculaService(MatriculaRepository repository) {
        this.repository = repository;
    }

    /** TODO sprint 3: autorização, período, duplicidade, limites 4/2, lotação e concorrência. */
    @Transactional
    public MatriculaDto.Resposta matricular(MatriculaDto.Requisicao requisicao) {
        throw new FuncionalidadeNaoImplementadaException("Realizar matrícula");
    }

    /** TODO sprint 3: validar o titular e o período; preservar o histórico. */
    @Transactional
    public void cancelar(Long id) {
        throw new FuncionalidadeNaoImplementadaException("Cancelar matrícula");
    }

    public List<MatriculaDto.Resposta> consultarPorAluno(Long alunoId, String semestre) {
        throw new FuncionalidadeNaoImplementadaException("Consultar matrículas do aluno");
    }

    public List<MatriculaDto.Resposta> consultarPorTurma(String turmaCodigo) {
        throw new FuncionalidadeNaoImplementadaException("Consultar matrículas da turma");
    }
}
