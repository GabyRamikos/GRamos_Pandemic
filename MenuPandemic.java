package nfds;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPandemic extends JFrame {
    
    public MenuPandemic() {
        super("Menú Pandemic");
        
        // Crear componentes del menú
        JButton nuevaPartida = new JButton("Nueva partida");
        JButton cargarPartida = new JButton("Cargar partida");
        JButton informacion = new JButton("Información");
        JButton puntajes = new JButton("Resumen de puntajes");
        JButton autores = new JButton("Autores");
        JButton version = new JButton("Versión");
        JButton salir = new JButton("Salir");
        
        // Agregar componentes al panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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
                        "2. Cada jugador representa a un personaje con habilidades especiales.\n" +
                        "3. Los jugadores trabajan juntos para recolectar cartas de enfermedades, tratar pacientes y encontrar la cura.\n" +
                        "4. Los jugadores pierden si se quedan sin cartas de enfermedad, si hay demasiadas epidemias o si no logran encontrar la cura a tiempo.\n" +
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
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MenuPandemic();
    }
}
