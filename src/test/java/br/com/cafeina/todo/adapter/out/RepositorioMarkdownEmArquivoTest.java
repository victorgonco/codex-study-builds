package br.com.cafeina.todo.adapter.out;

import br.com.cafeina.todo.domain.Tarefa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RepositorioMarkdownEmArquivoTest {

    @TempDir
    Path diretorioTemporario;

    @Test
    void deveCriarArquivoMarkdownNoPrimeiroCadastro() throws Exception {
        Path arquivo = diretorioTemporario.resolve("dados").resolve("tarefas.md");
        var repositorio = new RepositorioMarkdownEmArquivo(arquivo, new SerializadorMarkdownSimples());

        repositorio.salvar(new Tarefa("tarefa-001", "Comprar cafe", "Comprar cafe para a semana"));

        assertTrue(Files.exists(arquivo));
        String conteudo = Files.readString(arquivo);
        assertTrue(conteudo.contains("tarefa-001"));
        assertTrue(conteudo.contains("Comprar cafe"));
    }

    @Test
    void deveManterDuasTarefasNoMesmoArquivoMarkdown() throws Exception {
        Path arquivo = diretorioTemporario.resolve("dados").resolve("tarefas.md");
        var repositorio = new RepositorioMarkdownEmArquivo(arquivo, new SerializadorMarkdownSimples());

        repositorio.salvar(new Tarefa("tarefa-001", "Comprar cafe", "Comprar cafe para a semana"));
        repositorio.salvar(new Tarefa("tarefa-002", "Estudar Java", "Revisar fundamentos de Java 21"));

        String conteudo = Files.readString(arquivo);
        try (var arquivos = Files.list(arquivo.getParent())) {
            assertEquals(1, arquivos.count());
        }
        assertTrue(conteudo.contains("tarefa-001"));
        assertTrue(conteudo.contains("tarefa-002"));
    }

    @Test
    void deveLerTarefaPersistidaNoArquivoMarkdown() {
        Path arquivo = diretorioTemporario.resolve("dados").resolve("tarefas.md");
        var repositorio = new RepositorioMarkdownEmArquivo(arquivo, new SerializadorMarkdownSimples());
        repositorio.salvar(new Tarefa("tarefa-001", "Comprar cafe", "Comprar cafe para a semana"));

        Tarefa tarefa = repositorio.buscarPorId("tarefa-001").orElseThrow();

        assertEquals("Comprar cafe", tarefa.titulo());
        assertEquals("Comprar cafe para a semana", tarefa.descricao());
    }

    @Test
    void deveRetornarVazioQuandoArquivoAindaNaoExiste() {
        Path arquivo = diretorioTemporario.resolve("dados").resolve("tarefas.md");
        var repositorio = new RepositorioMarkdownEmArquivo(arquivo, new SerializadorMarkdownSimples());

        assertTrue(repositorio.buscarPorId("inexistente").isEmpty());
    }
}
