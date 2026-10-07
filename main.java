
import javax.swing.*;
import java.awt.*;

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
        Cocina cocina = new Cocina(new Orden[5]);

        JFrame ventana = new JFrame("Pedido de pizza");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        JTextField campoNombre = new JTextField(15);
        JTextField campoApellido = new JTextField(15);
        JTextField campoTelefono = new JTextField(15);
        JTextField campoInstrucciones = new JTextField(15);

        JComboBox<TipoBase> bases = new JComboBox<>(TipoBase.values());
        JComboBox<TipoSalsa> salsas = new JComboBox<>(TipoSalsa.values());
        JComboBox<Topping> topping1 = new JComboBox<>(Topping.values());
        JComboBox<Topping> topping2 = new JComboBox<>(Topping.values());
        JComboBox<Topping> topping3 = new JComboBox<>(Topping.values());

        JSpinner cantidadToppings = new JSpinner(
                new SpinnerNumberModel(0, 0, 3, 1)
        );

        JButton botonEnviar = new JButton("Enviar a cocina");
        JButton botonFinalizar = new JButton("Finalizar orden");
        botonFinalizar.setEnabled(false);

        panel.add(new JLabel("Nombre:"));
        panel.add(campoNombre);

        panel.add(new JLabel("Apellido:"));
        panel.add(campoApellido);

        panel.add(new JLabel("Teléfono:"));
        panel.add(campoTelefono);

        panel.add(new JLabel("Base:"));
        panel.add(bases);

        panel.add(new JLabel("Salsa:"));
        panel.add(salsas);

        panel.add(new JLabel("Cantidad de toppings:"));
        panel.add(cantidadToppings);

        panel.add(new JLabel("Topping 1:"));
        panel.add(topping1);

        panel.add(new JLabel("Topping 2:"));
        panel.add(topping2);

        panel.add(new JLabel("Topping 3:"));
        panel.add(topping3);

        panel.add(new JLabel("Instrucciones:"));
        panel.add(campoInstrucciones);

        panel.add(botonEnviar);
        panel.add(botonFinalizar);

        final Cliente[] clienteActual = new Cliente[1];
        final int[] numeroOrden = new int[1];

        botonEnviar.addActionListener(evento -> {
            String nombre = campoNombre.getText().trim();
            String apellido = campoApellido.getText().trim();
            String telefono = campoTelefono.getText().trim();

            if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(ventana, "Completa los datos del cliente.");
                return;
            }

            clienteActual[0] = new Cliente(nombre, apellido, telefono);

            Topping[] toppings = new Topping[3];
            int cantidad = (int) cantidadToppings.getValue();

            if (cantidad >= 1) {
                toppings[0] = (Topping) topping1.getSelectedItem();
            }
            if (cantidad >= 2) {
                toppings[1] = (Topping) topping2.getSelectedItem();
            }
            if (cantidad == 3) {
                toppings[2] = (Topping) topping3.getSelectedItem();
            }

            Pizza pizza = new Pizza(
                    (TipoBase) bases.getSelectedItem(),
                    (TipoSalsa) salsas.getSelectedItem(),
                    toppings
            );

            Orden orden = new Orden(pizza, campoInstrucciones.getText());
            numeroOrden[0] = cocina.ordenVacia();

            if (numeroOrden[0] == -1) {
                JOptionPane.showMessageDialog(ventana, "La cocina está llena.");
                return;
            }

            cocina.setOrdenRecibida(orden);
            botonEnviar.setEnabled(false);
            botonFinalizar.setEnabled(true);

            JOptionPane.showMessageDialog(ventana, "Orden enviada a cocina.");
        });

        botonFinalizar.addActionListener(evento -> {
            cocina.setOrdenFinalizada(numeroOrden[0]);

            Orden ordenTerminada = cocina.getOrdenFinalizada()[numeroOrden[0]];
            Pedido pedido = new Pedido(clienteActual[0], ordenTerminada);
            clienteActual[0].setPedido(pedido);

            botonFinalizar.setEnabled(false);

            JOptionPane.showMessageDialog(
                    ventana,
                    "Pedido finalizado para " + campoNombre.getText() + " " + campoApellido.getText()
            );
        });

        ventana.add(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}