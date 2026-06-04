package br.com.cafeina.todo.application;

import br.com.cafeina.todo.application.port.out.RepositorioDeTarefas;
import br.com.cafeina.todo.domain.Tarefa;
import br.com.cafeina.todo.domain.exception.TarefaNaoEncontradaException;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LerTarefaServiceTest {

    @Test
    void deveLerTarefaExistente() {
        var repositorio = new RepositorioComUmaTarefa();
        var servico = new LerTarefaService(repositorio);

        Tarefa tarefa = servico.executar(new LerTarefaCommand("tarefa-001"));

        assertEquals("Comprar cafe", tarefa.titulo());
        assertEquals("Comprar cafe para a semana", tarefa.descricao());
    }

    @Test
    void deveFalharAoLerTarefaInexistente() {
        var repositorio = new RepositorioVazio();
        var servico = new LerTarefaService(repositorio);

        assertThrows(TarefaNaoEncontradaException.class, () -> servico.executar(new LerTarefaCommand("nao-existe")));
    }

    private static final class RepositorioComUmaTarefa implements RepositorioDeTarefas {
        @Override
        public void salvar(Tarefa tarefa) {
            throw new UnsupportedOperationException("Nao usado neste teste");
        }

        @Override
        public Optional<Tarefa> buscarPorId(String id) {
            if ("tarefa-001".equals(id)) {
                return Optional.of(new Tarefa("tarefa-001", "Comprar cafe", "Comprar cafe para a semana"));
            }

            return Optional.empty();
        }
    }

    private static final class RepositorioVazio implements RepositorioDeTarefas {
        @Override
        public void salvar(Tarefa tarefa) {
            throw new UnsupportedOperationException("Nao usado neste teste");
        }

        @Override
        public Optional<Tarefa> buscarPorId(String id) {
            return Optional.empty();
        }
    }
}
