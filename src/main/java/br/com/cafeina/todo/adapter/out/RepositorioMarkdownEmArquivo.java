package br.com.cafeina.todo.adapter.out;

import br.com.cafeina.todo.application.port.out.RepositorioDeTarefas;
import br.com.cafeina.todo.application.port.out.SerializadorMarkdownDeTarefas;
import br.com.cafeina.todo.domain.Tarefa;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioMarkdownEmArquivo implements RepositorioDeTarefas {
    private final Path arquivoMarkdown;
    private final SerializadorMarkdownDeTarefas serializador;

    public RepositorioMarkdownEmArquivo(Path arquivoMarkdown, SerializadorMarkdownDeTarefas serializador) {
        this.arquivoMarkdown = arquivoMarkdown;
        this.serializador = serializador;
    }

    @Override
    public void salvar(Tarefa tarefa) {
        List<Tarefa> tarefas = new ArrayList<>(carregarTarefas());
        tarefas.add(tarefa);
        garantirEstrutura();
        escreverConteudo(serializador.serializar(tarefas));
    }

    @Override
    public Optional<Tarefa> buscarPorId(String id) {
        return carregarTarefas().stream()
                .filter(tarefa -> tarefa.id().equals(id))
                .findFirst();
    }

    private List<Tarefa> carregarTarefas() {
        if (Files.notExists(arquivoMarkdown)) {
            return List.of();
        }

        try {
            return serializador.desserializar(Files.readString(arquivoMarkdown));
        } catch (IOException exception) {
            throw new UncheckedIOException("Falha ao ler arquivo de tarefas", exception);
        }
    }

    private void garantirEstrutura() {
        try {
            Path diretorioPai = arquivoMarkdown.getParent();
            if (diretorioPai != null) {
                Files.createDirectories(diretorioPai);
            }

            if (Files.notExists(arquivoMarkdown)) {
                Files.createFile(arquivoMarkdown);
            }
        } catch (IOException exception) {
            throw new UncheckedIOException("Falha ao preparar armazenamento", exception);
        }
    }

    private void escreverConteudo(String conteudo) {
        try {
            Files.writeString(arquivoMarkdown, conteudo);
        } catch (IOException exception) {
            throw new UncheckedIOException("Falha ao escrever arquivo de tarefas", exception);
        }
    }
}
