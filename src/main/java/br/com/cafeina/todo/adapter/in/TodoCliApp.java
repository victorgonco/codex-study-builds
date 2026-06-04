package br.com.cafeina.todo.adapter.in;

import br.com.cafeina.todo.adapter.out.GeradorDeUuid;
import br.com.cafeina.todo.adapter.out.RepositorioMarkdownEmArquivo;
import br.com.cafeina.todo.adapter.out.SerializadorMarkdownSimples;
import br.com.cafeina.todo.application.CriarTarefaCommand;
import br.com.cafeina.todo.application.CriarTarefaService;
import br.com.cafeina.todo.application.LerTarefaCommand;
import br.com.cafeina.todo.application.LerTarefaService;
import br.com.cafeina.todo.domain.Tarefa;
import br.com.cafeina.todo.domain.exception.TarefaNaoEncontradaException;
import br.com.cafeina.todo.domain.exception.ValidacaoException;

import java.io.PrintStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TodoCliApp {
    private final PrintStream saida;
    private final PrintStream erro;

    public TodoCliApp(PrintStream saida, PrintStream erro) {
        this.saida = saida;
        this.erro = erro;
    }

    public static void main(String[] args) {
        int codigo = new TodoCliApp(System.out, System.err).executar(args);
        System.exit(codigo);
    }

    public int executar(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Comando obrigatorio");
            }

            String comando = args[0];
            Map<String, String> opcoes = extrairOpcoes(args);
            Path arquivo = Path.of(obrigatorio(opcoes, "arquivo"));
            var repositorio = new RepositorioMarkdownEmArquivo(arquivo, new SerializadorMarkdownSimples());

            if ("criar".equals(comando)) {
                return executarCriacao(opcoes, repositorio);
            }

            if ("ler".equals(comando)) {
                return executarLeitura(opcoes, repositorio);
            }

            throw new IllegalArgumentException("Comando invalido");
        } catch (ValidacaoException | TarefaNaoEncontradaException | IllegalArgumentException exception) {
            erro.println(exception.getMessage());
            return 1;
        }
    }

    private int executarCriacao(Map<String, String> opcoes, RepositorioMarkdownEmArquivo repositorio) {
        var casoDeUso = new CriarTarefaService(repositorio, new GeradorDeUuid());
        Tarefa tarefa = casoDeUso.executar(new CriarTarefaCommand(
                obrigatorio(opcoes, "titulo"),
                opcoes.getOrDefault("descricao", "")
        ));

        saida.println("Tarefa criada com sucesso");
        saida.println("ID: " + tarefa.id());
        return 0;
    }

    private int executarLeitura(Map<String, String> opcoes, RepositorioMarkdownEmArquivo repositorio) {
        var casoDeUso = new LerTarefaService(repositorio);
        Tarefa tarefa = casoDeUso.executar(new LerTarefaCommand(obrigatorio(opcoes, "id")));

        saida.println("ID: " + tarefa.id());
        saida.println("Titulo: " + tarefa.titulo());
        saida.println("Descricao: " + tarefa.descricao());
        return 0;
    }

    private Map<String, String> extrairOpcoes(String[] args) {
        Map<String, String> opcoes = new HashMap<>();

        for (int indice = 1; indice < args.length; indice++) {
            String argumento = args[indice];
            if (!argumento.startsWith("--") || !argumento.contains("=")) {
                throw new IllegalArgumentException("Argumento invalido: " + argumento);
            }

            String[] partes = argumento.substring(2).split("=", 2);
            opcoes.put(partes[0], partes.length > 1 ? partes[1] : "");
        }

        return opcoes;
    }

    private String obrigatorio(Map<String, String> opcoes, String chave) {
        if (!opcoes.containsKey(chave)) {
            throw new IllegalArgumentException("Parametro obrigatorio: " + chave);
        }

        return opcoes.get(chave);
    }
}
