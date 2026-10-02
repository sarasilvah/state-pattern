package com.univassouras.state;

public class EstadoCancelado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel pagar: o pedido foi cancelado.");
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel enviar: o pedido foi cancelado.");
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel entregar: o pedido foi cancelado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel cancelar: o pedido ja esta cancelado.");
    }

    @Override
    public String nome() {
        return "CANCELADO";
    }
}
