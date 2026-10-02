package com.univassouras.state;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        System.out.println("Estado atual: " + pedido.getEstadoAtual());

        pedido.enviar();
        pedido.pagar();
        pedido.enviar();
        pedido.entregar();
        pedido.cancelar();

        System.out.println();
        System.out.println("Historico completo do pedido:");
        for (String linha : pedido.getHistorico()) {
            System.out.println("- " + linha);
        }

        System.out.println();
        System.out.println("Estado final: " + pedido.getEstadoAtual());
    }
}
