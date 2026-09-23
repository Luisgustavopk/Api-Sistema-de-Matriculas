package br.edu.sistemamatricula;

import br.edu.sistemamatricula.modelo.*;
import br.edu.sistemamatricula.repository.*;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
@Transactional
class PersistenciaTest {
    @Autowired AlunoRepository alunos;
    @Autowired ProfessorRepository professores;
    @Autowired SecretariaRepository secretarias;
    @Autowired UsuarioRepository usuarios;
    @Autowired CursoRepository cursos;
    @Autowired DisciplinaRepository disciplinas;
    @Autowired TurmaRepository turmas;
    @Autowired MatriculaRepository matriculas;
    @Autowired EntityManager entityManager;

    @Test
    void persisteERecarregaHerancaEAssociacoes() {
        LocalDate hoje = LocalDate.of(2026, 9, 22);
        Aluno aluno = alunos.save(Aluno.builder().nome("Ana").email("ana@example.test")
                .login("ana").senhaHash("hash-apenas-para-teste").dataIngresso(hoje)
                .situacaoAcademica("REGULAR").build());
        Professor professor = professores.save(Professor.builder().nome("Beto").email("beto@example.test")
                .login("beto").senhaHash("hash-apenas-para-teste").titulacao("Mestre")
                .areaAtuacao("Software").dataAdmissao(hoje).build());
        Secretaria secretaria = secretarias.save(Secretaria.builder().nome("Carla").email("carla@example.test")
                .login("carla").senhaHash("hash-apenas-para-teste").setor("Acadêmico").cargo("Secretária").build());
        Disciplina disciplina = disciplinas.save(Disciplina.builder().codigo("LDS").nome("Laboratório").creditos(4).build());
        Curso curso = Curso.builder().codigo("ES").nome("Engenharia de Software").totalCreditos(200)
                .disciplinas(new ArrayList<>(List.of(disciplina))).build();
        cursos.save(curso);
        Turma turma = turmas.save(Turma.builder().codigo("LDS-2026-2").semestre("2026-2")
                .inicioMatriculas(hoje).fimMatriculas(hoje.plusDays(10)).situacao("ABERTA")
                .disciplina(disciplina).professor(professor).build());
        Matricula matricula = matriculas.save(Matricula.builder().data(hoje).optativa(false)
                .situacao("ATIVA").aluno(aluno).turma(turma).build());
        entityManager.flush();
        entityManager.clear();

        Matricula recarregada = matriculas.findById(matricula.getId()).orElseThrow();
        assertThat(recarregada.getAluno().getNome()).isEqualTo("Ana");
        assertThat(recarregada.getTurma().getDisciplina().getCodigo()).isEqualTo("LDS");
        assertThat(recarregada.getTurma().getProfessor().getCodigoDePessoa()).isEqualTo(professor.getCodigoDePessoa());
        assertThat(alunos.findById(aluno.getCodigoDePessoa()).orElseThrow().getMatriculas()).hasSize(1);
        assertThat(professores.findById(professor.getCodigoDePessoa()).orElseThrow().getTurmas()).hasSize(1);
        assertThat(disciplinas.findById("LDS").orElseThrow().getTurmas()).hasSize(1);
        assertThat(cursos.findById("ES").orElseThrow().getDisciplinas()).hasSize(1);
        assertThat(usuarios.findByLogin("carla").orElseThrow()).isInstanceOf(Secretaria.class);
        assertThat(secretarias.findById(secretaria.getCodigoDePessoa())).isPresent();

        cursos.deleteById("ES");
        entityManager.flush();
        entityManager.clear();
        assertThat(disciplinas.findById("LDS")).isPresent();
    }

    @Test
    void loginUnicoValeParaTodosOsPerfis() {
        LocalDate hoje = LocalDate.of(2026, 9, 22);
        alunos.saveAndFlush(Aluno.builder().nome("Ana").email("ana@example.test")
                .login("mesmo-login").senhaHash("hash-teste").dataIngresso(hoje).situacaoAcademica("REGULAR").build());
        assertThatThrownBy(() -> professores.saveAndFlush(Professor.builder().nome("Beto").email("beto@example.test")
                .login("mesmo-login").senhaHash("hash-teste").titulacao("Mestre")
                .areaAtuacao("Software").dataAdmissao(hoje).build()))
                .isInstanceOf(org.springframework.dao.DataIntegrityViolationException.class);
    }
}
