package br.edu.sistemamatricula;

import br.edu.sistemamatricula.modelo.Disciplina;
import br.edu.sistemamatricula.repository.DisciplinaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class PersistenciaEmArquivoTest {
    @TempDir Path diretorio;

    private ConfigurableApplicationContext iniciar() {
        return new SpringApplicationBuilder(SistemaMatriculaApplication.class)
                .web(WebApplicationType.NONE)
                .run("--spring.datasource.url=jdbc:h2:file:" + diretorio.resolve("banco").toAbsolutePath(),
                        "--spring.datasource.username=sa", "--spring.datasource.password=",
                        "--spring.main.banner-mode=off");
    }

    @Test
    void dadosSobrevivemAoReinicioDaAplicacao() {
        try (var contexto = iniciar()) {
            contexto.getBean(DisciplinaRepository.class).saveAndFlush(
                    Disciplina.builder().codigo("LDS").nome("Laboratório").creditos(4).build());
        }
        try (var contexto = iniciar()) {
            var disciplina = contexto.getBean(DisciplinaRepository.class).findById("LDS").orElseThrow();
            assertThat(disciplina.getNome()).isEqualTo("Laboratório");
            assertThat(disciplina.getCreditos()).isEqualTo(4);
        }
    }
}
