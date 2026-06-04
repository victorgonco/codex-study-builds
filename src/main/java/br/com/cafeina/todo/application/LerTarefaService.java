package br.com.cafeina.todo.application;

import br.com.cafeina.todo.application.port.in.LerTarefaUseCase;
import br.com.cafeina.todo.application.port.out.RepositorioDeTarefas;
import br.com.cafeina.todo.domain.Tarefa;
import br.com.cafeina.todo.domain.exception.TarefaNaoEncontradaException;

public class LerTarefaService implements LerTarefaUseCase {
    private final RepositorioDeTarefas repositorioDeTarefas;

    public LerTarefaService(RepositorioDeTarefas repositorioDeTarefas) {
        this.repositorioDeTarefas = repositorioDeTarefas;
    }

    @Override
    public Tarefa executar(LerTarefaCommand command) {
        return repositorioDeTarefas.buscarPorId(command.id())
                .orElseThrow(() -> new TarefaNaoEncontradaException("Tarefa nao encontrada"));
    }
}
