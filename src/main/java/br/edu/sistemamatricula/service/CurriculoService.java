package br.edu.sistemamatricula.service;

import br.edu.sistemamatricula.dto.DisciplinaDto;
import br.edu.sistemamatricula.exception.FuncionalidadeNaoImplementadaException;
import br.edu.sistemamatricula.repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CurriculoService {
    private final CursoRepository repository;

    public CurriculoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<DisciplinaDto.Resposta> consultarDisciplinas(String cursoCodigo) {
        throw new FuncionalidadeNaoImplementadaException("Listar disciplinas do curso");
    }

    @Transactional
    public List<DisciplinaDto.Resposta> gerarCurriculo(String cursoCodigo, String semestre) {
        throw new FuncionalidadeNaoImplementadaException("Gerar currículo do semestre");
    }

    @Transactional
    public void adicionarDisciplina(String cursoCodigo, String disciplinaCodigo) {
        throw new FuncionalidadeNaoImplementadaException("Adicionar disciplina ao curso");
    }

    @Transactional
    public void removerDisciplina(String cursoCodigo, String disciplinaCodigo) {
        throw new FuncionalidadeNaoImplementadaException("Remover disciplina do curso");
    }
}
