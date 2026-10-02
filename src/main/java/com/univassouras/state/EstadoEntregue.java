package com.univassouras.state;

public class EstadoEntregue implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel pagar: o pedido ja foi entregue.");
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel enviar: o pedido ja foi entregue.");
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel entregar: o pedido ja foi entregue.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.registrarMensagem("Nao e possivel cancelar: o pedido ja foi entregue.");
    }

    @Override
    public String nome() {
        return "ENTREGUE";
    }
}
