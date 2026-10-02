package com.univassouras.state;

public class EstadoPago implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel pagar: o pedido ja esta pago.");
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.mudarEstado(new EstadoEnviado());
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel entregar: o pedido ainda nao foi enviado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.mudarEstado(new EstadoCancelado());
    }

    @Override
    public String nome() {
        return "PAGO";
    }
}
