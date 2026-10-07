package model2;

import model2.Cliente;
import model2.Pizza;
public class Orden {
    
    private Pizza pizza;
    private String instrucciones;

    public Orden(Pizza pizza, String instrucciones){
        this.pizza = pizza;
        this.instrucciones = instrucciones;
    }
}
