package br.com.cafeina.todo.application.port.in;

import br.com.cafeina.todo.application.CriarTarefaCommand;
import br.com.cafeina.todo.domain.Tarefa;

public interface CriarTarefaUseCase {
    Tarefa executar(CriarTarefaCommand command);
}
