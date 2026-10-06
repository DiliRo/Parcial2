package model2;

public class Pedido {
    private Cliente cliente;
    private Orden ordenFinalizada;

    public Pedido(Cliente cliente, Orden ordenFinalizada) {
        this.cliente = cliente;
        this.ordenFinalizada = ordenFinalizada;
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setOrdenFinalizada(Orden ordenFinalizada) {
        this.ordenFinalizada = ordenFinalizada;
    }
}
