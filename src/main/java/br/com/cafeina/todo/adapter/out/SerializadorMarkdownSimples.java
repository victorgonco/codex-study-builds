package br.com.cafeina.todo.adapter.out;

import br.com.cafeina.todo.application.port.out.SerializadorMarkdownDeTarefas;
import br.com.cafeina.todo.domain.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class SerializadorMarkdownSimples implements SerializadorMarkdownDeTarefas {
    private static final String CABECALHO = "# Tarefas";

    @Override
    public String serializar(List<Tarefa> tarefas) {
        StringBuilder builder = new StringBuilder();
        builder.append(CABECALHO).append(System.lineSeparator()).append(System.lineSeparator());

        for (Tarefa tarefa : tarefas) {
            builder.append("## ").append(tarefa.id()).append(System.lineSeparator());
            builder.append("titulo: ").append(tarefa.titulo()).append(System.lineSeparator());
            builder.append("descricao: ").append(tarefa.descricao()).append(System.lineSeparator());
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }

    @Override
    public List<Tarefa> desserializar(String conteudo) {
        List<Tarefa> tarefas = new ArrayList<>();
        if (conteudo == null || conteudo.isBlank()) {
            return tarefas;
        }

        String[] blocos = conteudo.split("(?m)^## ");
        for (String bloco : blocos) {
            String trecho = bloco.trim();
            if (trecho.isEmpty() || trecho.startsWith("# Tarefas")) {
                continue;
            }

            String[] linhas = trecho.split("\\R");
            if (linhas.length < 3) {
                continue;
            }

            String id = linhas[0].trim();
            String titulo = extrairValor(linhas[1], "titulo:");
            String descricao = extrairValor(linhas[2], "descricao:");
            tarefas.add(new Tarefa(id, titulo, descricao));
        }

        return tarefas;
    }

    private String extrairValor(String linha, String prefixo) {
        if (!linha.startsWith(prefixo)) {
            return "";
        }

        return linha.substring(prefixo.length()).trim();
    }
}
