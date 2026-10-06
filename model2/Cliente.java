package model2;

public class Cliente {
    private String nombre;
    private String apellido;
    private String numeroTelefono;
    private Pedido pedido;

    public Cliente(String nombre, String apellido, String numeroTelefono) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.numeroTelefono = numeroTelefono;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return this.pedido;
    }
}