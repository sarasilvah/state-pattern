package com.univassouras.state;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private EstadoPedido estado;
    private final List<String> historico = new ArrayList<>();

    public Pedido() {
        this.estado = new EstadoNovo();
        this.historico.add("Pedido criado no estado " + estado.nome());
    }

    public void pagar() {
        estado.pagar(this);
    }

    public void enviar() {
        estado.enviar(this);
    }

    public void entregar() {
        estado.entregar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    void mudarEstado(EstadoPedido novoEstado) {
        this.estado = novoEstado;
        this.historico.add("Pedido mudou para o estado " + novoEstado.nome());
    }

    void registrarMensagem(String mensagem) {
        this.historico.add(mensagem);
    }

    public String getEstadoAtual() {
        return estado.nome();
    }

    public List<String> getHistorico() {
        return historico;
    }
}
