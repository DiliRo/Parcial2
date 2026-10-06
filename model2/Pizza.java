package model2;

import enums.TipoBase;
import enums.TipoSalsa;
import enums.Topping;

public class Pizza {

    private TipoBase tipoBase;
    private TipoSalsa tipoSalsa;
    private Topping toppings[] = new Topping[3];


    public Pizza(TipoBase tipoBase, TipoSalsa tipoSalsa, Topping toppings[]){
        this.tipoBase = tipoBase;
        this.tipoSalsa = tipoSalsa;
        this.toppings = toppings;
    }


    public Pizza(Topping topping){
        this.toppings[0] = topping;
    }

    public Pizza(TipoBase tipoBase){
        this.tipoBase = tipoBase;
    }

}
