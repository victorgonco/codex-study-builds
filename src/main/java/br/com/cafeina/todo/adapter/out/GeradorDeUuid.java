package br.com.cafeina.todo.adapter.out;

import br.com.cafeina.todo.application.port.out.GeradorDeIdentificador;

import java.util.UUID;

public class GeradorDeUuid implements GeradorDeIdentificador {
    @Override
    public String gerar() {
        return UUID.randomUUID().toString();
    }
}
