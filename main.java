import java.util.Scanner;

import enums.TipoBase;
import enums.TipoSalsa;
import enums.Topping;
import model2.Cliente;
import model2.Cocina;
import model2.Orden;
import model2.Pedido;
import model2.Pizza;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, telefono);

        TipoBase[] bases = TipoBase.values();
        System.out.println("Elige la base:");
        for (int i = 0; i < bases.length; i++) {
            System.out.println((i + 1) + ". " + bases[i]);
        }
        TipoBase base = bases[scanner.nextInt() - 1];

        TipoSalsa[] salsas = TipoSalsa.values();
        System.out.println("Elige la salsa:");
        for (int i = 0; i < salsas.length; i++) {
            System.out.println((i + 1) + ". " + salsas[i]);
        }
        TipoSalsa salsa = salsas[scanner.nextInt() - 1];

        Topping[] opcionesTopping = Topping.values();
        Topping[] toppings = new Topping[3];

        System.out.print("¿Cuántos toppings quieres? (0 a 3): ");
        int cantidad = scanner.nextInt();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Elige el topping " + (i + 1) + ":");

            for (int j = 0; j < opcionesTopping.length; j++) {
                System.out.println((j + 1) + ". " + opcionesTopping[j]);
            }

            toppings[i] = opcionesTopping[scanner.nextInt() - 1];
        }

        scanner.nextLine();

        Pizza pizza = new Pizza(base, salsa, toppings);

        System.out.print("Instrucciones: ");
        String instrucciones = scanner.nextLine();

        Orden orden = new Orden(pizza, instrucciones);
        Cocina cocina = new Cocina(new Orden[5]);

        int numeroOrden = cocina.ordenVacia();
        cocina.setOrdenRecibida(orden);

        System.out.println("La orden fue recibida por cocina.");
        System.out.println("Presiona Enter cuando esté terminada.");
        scanner.nextLine();

        cocina.setOrdenFinalizada(numeroOrden);

        Orden ordenTerminada = cocina.getOrdenFinalizada()[numeroOrden];
        Pedido pedido = new Pedido(cliente, ordenTerminada);
        cliente.setPedido(pedido);

        System.out.println("Pedido terminado y asignado a " + nombre + " " + apellido + ".");
    }
}