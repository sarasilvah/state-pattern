package com.univassouras.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PedidoTest {

    @Test
    void pedidoDeveComecarNoEstadoNovo() {
        Pedido pedido = new Pedido();

        assertEquals("NOVO", pedido.getEstadoAtual());
    }

    @Test
    void pagarDeveTransicionarDeNovoParaPago() {
        Pedido pedido = new Pedido();

        pedido.pagar();

        assertEquals("PAGO", pedido.getEstadoAtual());
    }

    @Test
    void naoDevePermitirEnviarPedidoAindaNaoPago() {
        Pedido pedido = new Pedido();

        pedido.enviar();

        assertEquals("NOVO", pedido.getEstadoAtual());
        assertTrue(pedido.getHistorico().get(pedido.getHistorico().size() - 1).contains("Nao e possivel enviar"));
    }

    @Test
    void fluxoCompletoDevePassarPorTodosOsEstadosEmOrdem() {
        Pedido pedido = new Pedido();

        pedido.pagar();
        assertEquals("PAGO", pedido.getEstadoAtual());

        pedido.enviar();
        assertEquals("ENVIADO", pedido.getEstadoAtual());

        pedido.entregar();
        assertEquals("ENTREGUE", pedido.getEstadoAtual());
    }

    @Test
    void pedidoPagoDevePermitirCancelamento() {
        Pedido pedido = new Pedido();

        pedido.pagar();
        pedido.cancelar();

        assertEquals("CANCELADO", pedido.getEstadoAtual());
    }

    @Test
    void pedidoEntregueNaoDevePermitirCancelamento() {
        Pedido pedido = new Pedido();

        pedido.pagar();
        pedido.enviar();
        pedido.entregar();
        pedido.cancelar();

        assertEquals("ENTREGUE", pedido.getEstadoAtual());
        assertTrue(pedido.getHistorico().get(pedido.getHistorico().size() - 1).contains("Nao e possivel cancelar"));
    }

    @Test
    void pedidoEnviadoNaoDevePermitirCancelamento() {
        Pedido pedido = new Pedido();

        pedido.pagar();
        pedido.enviar();
        pedido.cancelar();

        assertEquals("ENVIADO", pedido.getEstadoAtual());
    }
}
