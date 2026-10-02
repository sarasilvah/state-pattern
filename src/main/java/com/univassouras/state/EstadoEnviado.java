package com.univassouras.state;

public class EstadoEnviado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel pagar: o pedido ja esta pago e enviado.");
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel enviar: o pedido ja esta a caminho.");
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.mudarEstado(new EstadoEntregue());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel cancelar: o pedido ja foi enviado.");
    }

    @Override
    public String nome() {
        return "ENVIADO";
    }
}
