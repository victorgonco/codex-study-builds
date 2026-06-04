package br.com.cafeina.todo.application.port.out;

import br.com.cafeina.todo.domain.Tarefa;

import java.util.Optional;

public interface RepositorioDeTarefas {
    void salvar(Tarefa tarefa);

    Optional<Tarefa> buscarPorId(String id);
}
