package model2;

import model2.Cliente;
import model2.Pizza;
public class Orden {
    
    private Cliente cliente;
    private Pizza pizza;
    private String instrucciones;

    public Orden(Cliente cliente, Pizza pizza, String instrucciones){
        this.cliente = cliente;
        this.pizza = pizza;
        this.instrucciones = instrucciones;
    }
}
