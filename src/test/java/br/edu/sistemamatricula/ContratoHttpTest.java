package br.edu.sistemamatricula;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ContratoHttpTest {
    @Autowired Environment environment;
    private final HttpClient client = HttpClient.newHttpClient();

    private HttpResponse<String> post(String path, String json) throws Exception {
        URI uri = URI.create("http://127.0.0.1:" + environment.getProperty("local.server.port") + path);
        return client.send(HttpRequest.newBuilder(uri).header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json)).build(), HttpResponse.BodyHandlers.ofString());
    }

    @Test
    void cadastroValidoExplicitaStubDaSprint3() throws Exception {
        var response = post("/api/cursos", """
                {"codigo":"ES","nome":"Engenharia de Software","totalCreditos":200,"disciplinas":["LDS"]}
                """);
        assertThat(response.statusCode()).isEqualTo(501);
        assertThat(response.headers().firstValue("content-type").orElseThrow()).contains("application/problem+json");
        assertThat(response.body()).contains("sprint 3");
    }

    @Test
    void validacaoAconteceAntesDoCasoDeUso() throws Exception {
        var response = post("/api/cursos", """
                {"codigo":"","nome":"","totalCreditos":0,"disciplinas":[]}
                """);
        assertThat(response.statusCode()).isEqualTo(400);
        assertThat(response.body()).contains("erros", "totalCreditos", "disciplinas");
    }

    @Test
    void erroNaoExibeCredencialRejeitada() throws Exception {
        String senhaInvalida = "senha-sigilosa-".repeat(15);
        var response = post("/api/autenticacao", "{\"login\":\"ana\",\"senha\":\"" + senhaInvalida + "\"}");
        assertThat(response.statusCode()).isEqualTo(400);
        assertThat(response.body()).doesNotContain(senhaInvalida, "stackTrace", "senhaHash");
    }

    @Test
    void jsonMalformadoRetornaErroControlado() throws Exception {
        var response = post("/api/cursos", "{invalido");
        assertThat(response.statusCode()).isEqualTo(400);
        assertThat(response.body()).contains("Formato da requisição inválido");
    }
}
