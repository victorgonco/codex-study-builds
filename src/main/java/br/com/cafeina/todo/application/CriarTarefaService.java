package br.com.cafeina.todo.application;

import br.com.cafeina.todo.application.port.in.CriarTarefaUseCase;
import br.com.cafeina.todo.application.port.out.GeradorDeIdentificador;
import br.com.cafeina.todo.application.port.out.RepositorioDeTarefas;
import br.com.cafeina.todo.domain.Tarefa;
import br.com.cafeina.todo.domain.exception.ValidacaoException;

public class CriarTarefaService implements CriarTarefaUseCase {
    private final RepositorioDeTarefas repositorioDeTarefas;
    private final GeradorDeIdentificador geradorDeIdentificador;

    public CriarTarefaService(RepositorioDeTarefas repositorioDeTarefas, GeradorDeIdentificador geradorDeIdentificador) {
        this.repositorioDeTarefas = repositorioDeTarefas;
        this.geradorDeIdentificador = geradorDeIdentificador;
    }

    @Override
    public Tarefa executar(CriarTarefaCommand command) {
        if (command.titulo() == null || command.titulo().isBlank()) {
            throw new ValidacaoException("Titulo obrigatorio");
        }

        Tarefa tarefa = new Tarefa(
                geradorDeIdentificador.gerar(),
                command.titulo().trim(),
                command.descricao() == null ? "" : command.descricao().trim()
        );

        repositorioDeTarefas.salvar(tarefa);
        return tarefa;
    }
}
