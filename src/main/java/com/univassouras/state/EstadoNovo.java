package com.univassouras.state;

public class EstadoNovo implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        pedido.mudarEstado(new EstadoPago());
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel enviar: o pedido ainda nao foi pago.");
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel entregar: o pedido ainda nao foi pago nem enviado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.mudarEstado(new EstadoCancelado());
    }

    @Override
    public String nome() {
        return "NOVO";
    }
}
