package br.com.cafeina.todo.application;

import br.com.cafeina.todo.application.port.out.GeradorDeIdentificador;
import br.com.cafeina.todo.application.port.out.RepositorioDeTarefas;
import br.com.cafeina.todo.domain.Tarefa;
import br.com.cafeina.todo.domain.exception.ValidacaoException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CriarTarefaServiceTest {

    @Test
    void deveCriarTarefaValidaPreservandoTituloEDescricao() {
        var repositorio = new RepositorioEmMemoria();
        var gerador = new GeradorDeIdentificadorFixo("tarefa-001");
        var servico = new CriarTarefaService(repositorio, gerador);

        Tarefa tarefa = servico.executar(new CriarTarefaCommand("Comprar cafe", "Comprar cafe para a semana"));

        assertEquals("tarefa-001", tarefa.id());
        assertEquals("Comprar cafe", tarefa.titulo());
        assertEquals("Comprar cafe para a semana", tarefa.descricao());
        assertEquals(1, repositorio.tarefas().size());
    }

    @Test
    void deveRejeitarCriacaoSemTitulo() {
        var repositorio = new RepositorioEmMemoria();
        var gerador = new GeradorDeIdentificadorFixo("tarefa-001");
        var servico = new CriarTarefaService(repositorio, gerador);

        assertThrows(ValidacaoException.class, () -> servico.executar(new CriarTarefaCommand("  ", "Descricao sem titulo")));
        assertEquals(0, repositorio.tarefas().size());
    }

    @Test
    void deveManterTarefasAnterioresAoAdicionarNovaTarefa() {
        var repositorio = new RepositorioEmMemoria();
        repositorio.salvar(new Tarefa("tarefa-001", "Comprar cafe", "Comprar cafe para a semana"));
        var gerador = new GeradorDeIdentificadorFixo("tarefa-002");
        var servico = new CriarTarefaService(repositorio, gerador);

        servico.executar(new CriarTarefaCommand("Estudar Java", "Revisar fundamentos de Java 21"));

        assertEquals(2, repositorio.tarefas().size());
        assertEquals("Comprar cafe", repositorio.tarefas().get(0).titulo());
        assertEquals("Estudar Java", repositorio.tarefas().get(1).titulo());
    }

    private static final class RepositorioEmMemoria implements RepositorioDeTarefas {
        private final List<Tarefa> tarefas = new ArrayList<>();

        @Override
        public void salvar(Tarefa tarefa) {
            tarefas.add(tarefa);
        }

        @Override
        public Optional<Tarefa> buscarPorId(String id) {
            return tarefas.stream().filter(tarefa -> tarefa.id().equals(id)).findFirst();
        }

        List<Tarefa> tarefas() {
            return tarefas;
        }
    }

    private record GeradorDeIdentificadorFixo(String valor) implements GeradorDeIdentificador {
        @Override
        public String gerar() {
            return valor;
        }
    }
}
