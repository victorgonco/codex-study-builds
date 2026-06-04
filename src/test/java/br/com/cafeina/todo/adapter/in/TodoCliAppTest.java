package br.com.cafeina.todo.adapter.in;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TodoCliAppTest {

    @TempDir
    Path diretorioTemporario;

    @Test
    void deveCriarETerLeituraViaCli() {
        ByteArrayOutputStream saidaCriacao = new ByteArrayOutputStream();
        var appCriacao = new TodoCliApp(new PrintStream(saidaCriacao), new PrintStream(new ByteArrayOutputStream()));

        int codigoCriacao = appCriacao.executar(new String[]{
                "criar",
                "--arquivo=" + diretorioTemporario.resolve("tarefas.md"),
                "--titulo=Comprar cafe",
                "--descricao=Comprar cafe para a semana"
        });

        String id = extrairId(saidaCriacao.toString());
        ByteArrayOutputStream saidaLeitura = new ByteArrayOutputStream();
        var appLeitura = new TodoCliApp(new PrintStream(saidaLeitura), new PrintStream(new ByteArrayOutputStream()));

        int codigoLeitura = appLeitura.executar(new String[]{
                "ler",
                "--arquivo=" + diretorioTemporario.resolve("tarefas.md"),
                "--id=" + id
        });

        assertEquals(0, codigoCriacao);
        assertEquals(0, codigoLeitura);
        assertTrue(saidaCriacao.toString().contains("Tarefa criada com sucesso"));
        assertTrue(saidaLeitura.toString().contains("Comprar cafe"));
        assertTrue(saidaLeitura.toString().contains("Comprar cafe para a semana"));
    }

    @Test
    void deveInformarErroAoCriarSemTitulo() {
        ByteArrayOutputStream saidaErro = new ByteArrayOutputStream();
        var app = new TodoCliApp(new PrintStream(new ByteArrayOutputStream()), new PrintStream(saidaErro));

        int codigo = app.executar(new String[]{
                "criar",
                "--arquivo=" + diretorioTemporario.resolve("tarefas.md"),
                "--titulo= ",
                "--descricao=Descricao sem titulo"
        });

        assertEquals(1, codigo);
        assertTrue(saidaErro.toString().contains("Titulo obrigatorio"));
    }

    @Test
    void deveInformarErroAoLerTarefaInexistente() {
        ByteArrayOutputStream saidaErro = new ByteArrayOutputStream();
        var app = new TodoCliApp(new PrintStream(new ByteArrayOutputStream()), new PrintStream(saidaErro));

        int codigo = app.executar(new String[]{
                "ler",
                "--arquivo=" + diretorioTemporario.resolve("tarefas.md"),
                "--id=nao-existe"
        });

        assertEquals(1, codigo);
        assertTrue(saidaErro.toString().contains("Tarefa nao encontrada"));
    }

    private String extrairId(String saida) {
        String prefixo = "ID: ";
        int indice = saida.indexOf(prefixo);
        int fim = saida.indexOf(System.lineSeparator(), indice);
        return saida.substring(indice + prefixo.length(), fim).trim();
    }
}
