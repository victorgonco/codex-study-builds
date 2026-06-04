package br.com.cafeina.todo.application.port.out;

import br.com.cafeina.todo.domain.Tarefa;

import java.util.List;

public interface SerializadorMarkdownDeTarefas {
    String serializar(List<Tarefa> tarefas);

    List<Tarefa> desserializar(String conteudo);
}
