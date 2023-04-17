package Pandemic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;


public class Menu_Pandemic extends JFrame {
    
    public Menu_Pandemic() {
        super("Menú Pandemic");
        
        // Componentes del menú
        JButton nuevaPartida = new JButton("Nueva partida");
        JButton cargarPartida = new JButton("Cargar partida");
        JButton informacion = new JButton("Información");
        JButton puntajes = new JButton("Resumen de puntajes");
        JButton autores = new JButton("Autores");
        JButton version = new JButton("Versión");
        JButton salir = new JButton("Salir");
        
        // Componentes del panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 0, 10));        
        panel.add(nuevaPartida);
        panel.add(cargarPartida);
        panel.add(informacion);
        panel.add(puntajes);
        panel.add(autores);
        panel.add(version);
        panel.add(salir);
        add(panel);
        
        // Acción para el botón de información
        informacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Reglas del juego Pandemic:\n\n" +
                        "1. El objetivo del juego es encontrar la cura para cuatro enfermedades mortales.\n" +
                        "2. El jugador representa a un personaje con habilidades especiales.\n" +
                        "3. El jugador debe recolectar acciones de enfermedades, tratar pacientes y encontrar la cura.\n" +
                        "4. El jugador pierde si se queda sin ninguna accion sobre la enfermedad, si hay demasiadas epidemias o si no logra encontrar la cura a tiempo.\n" +
                        " ¡Buena suerte!\n", "Reglas del juego", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Acción para el botón de autores
        autores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Autores:\n\n" +
                        " Raul Pereira Costa \n raulpereira@hotmail.com\n" +
                        " Gabriel Ramos \n gabyramos290@gmail.com\n" +
                        " Roger Orteu", "Autores", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Acción para el botón de versión
        version.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Versión actual: 1.0", "Versión", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Acción para el botón de salir
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    // Método Principal
    public static void main(String[] args) {
        new Menu_Pandemic();
    }
}
