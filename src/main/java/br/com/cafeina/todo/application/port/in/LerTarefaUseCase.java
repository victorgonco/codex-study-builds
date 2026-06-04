package br.com.cafeina.todo.application.port.in;

import br.com.cafeina.todo.application.LerTarefaCommand;
import br.com.cafeina.todo.domain.Tarefa;

public interface LerTarefaUseCase {
    Tarefa executar(LerTarefaCommand command);
}
