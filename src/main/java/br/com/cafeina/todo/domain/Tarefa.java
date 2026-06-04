package br.com.cafeina.todo.domain;

import br.com.cafeina.todo.domain.exception.ValidacaoException;

public record Tarefa(String id, String titulo, String descricao) {

    public Tarefa {
        if (id == null || id.isBlank()) {
            throw new ValidacaoException("Identificador obrigatorio");
        }

        if (titulo == null || titulo.isBlank()) {
            throw new ValidacaoException("Titulo obrigatorio");
        }

        descricao = descricao == null ? "" : descricao;
    }
}
