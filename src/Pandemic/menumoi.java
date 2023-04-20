package Pandemic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class menumoi extends JFrame implements ActionListener {
	private JButton nuevaPartida, cargarPartida, resumenPuntajes, salir, autores, version, informacion;
	private JPanel panelPrincipal;
	private JLabel labelFondo;
	
	class ImagePanel extends JPanel {
	    private Image image;

	    public ImagePanel(Image image) {
	        this.image = image;
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this);
	    }
	}

	public menumoi() { // Menú 1.1
		super("Menú del juego");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// panel principal creado con layout establecido
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		
		// Meter el panel al frame
		getContentPane().add(panelPrincipal);

		// Cargar la imagen de fondo
		ImageIcon imagenFondo = new ImageIcon("fondo4.jpg");
		JPanel panelFondo = new ImagePanel(imagenFondo.getImage());
		panelFondo.setBounds(0, 0, 800, 600);
		panelPrincipal.add(panelFondo);
		
		labelFondo = new JLabel(imagenFondo);
		labelFondo.setBounds(0, 0, 800, 600);

		// botones creados
		nuevaPartida = new JButton("Nueva partida");
		nuevaPartida.setBounds(300, 150, 200, 50);
		nuevaPartida.addActionListener(this);

		cargarPartida = new JButton("Cargar partida");
		cargarPartida.setBounds(300, 225, 200, 50);
		cargarPartida.addActionListener(this);

		resumenPuntajes = new JButton("Resumen de puntajes");
		resumenPuntajes.setBounds(300, 300, 200, 50);
		resumenPuntajes.addActionListener(this);

		salir = new JButton("Salir");
		salir.setBounds(300, 375, 200, 50);
		salir.addActionListener(this);

		autores = new JButton("Autores");
		autores.setBounds(50, 525, 100, 25);
		autores.addActionListener(this);

		version = new JButton("Versión");
		version.setBounds(175, 525, 100, 25);
		version.addActionListener(this);

		informacion = new JButton("Información");
		informacion.setBounds(625, 525, 100, 25);
		informacion.addActionListener(this);

		// componentes agregados al panel principal
		panelPrincipal.add(nuevaPartida);
		panelPrincipal.add(cargarPartida);
		panelPrincipal.add(resumenPuntajes);
		panelPrincipal.add(salir);
		panelPrincipal.add(autores);
		panelPrincipal.add(version);
		panelPrincipal.add(informacion);
		panelPrincipal.add(labelFondo);

		// Mostrar ventana
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nuevaPartida) {
			// Acción para el botón de Nueva partida
			
		} else if (e.getSource() == cargarPartida) {
			// Acción para el botón de Cargar partida
			
		} else if (e.getSource() == resumenPuntajes) {
			// Acción para el botón de Resumen de puntajes
			
		} else if (e.getSource() == salir) {
			// Acción para el botón de Salir
			System.exit(0);
			
		} else if (e.getSource() == autores) {
			// Acción para el botón de Autores
			JOptionPane.showMessageDialog(null, "Autores:\n\n" +
                    " Raul Pereira Costa \n raulpereira@hotmail.com\n" +
                    " Gabriel Ramos \n gabyramos290@gmail.com\n" +
                    " Roger Orteu", "Autores", JOptionPane.INFORMATION_MESSAGE);
			
		} else if (e.getSource() == version) {
			// Acción para el botón de Versión
            JOptionPane.showMessageDialog(null, "Versión actual: 1.0", "Versión", JOptionPane.INFORMATION_MESSAGE);
            
		} else if (e.getSource() == informacion) {
			// Acción para el botón de Información
			JOptionPane.showMessageDialog(null, "Reglas del juego Pandemic:\n\n" +
                    "1. El objetivo del juego es encontrar la cura para cuatro enfermedades mortales.\n" +
                    "2. El jugador representa a un personaje con habilidades especiales.\n" +
                    "3. El jugador debe recolectar acciones de enfermedades, tratar pacientes y encontrar la cura.\n" +
                    "4. El jugador pierde si se queda sin ninguna accion sobre la enfermedad, si hay demasiadas epidemias o si no logra encontrar la cura a tiempo.\n" +
                    " ¡Buena suerte!\n", "Reglas del juego", JOptionPane.INFORMATION_MESSAGE);		}
	}

	public static void main(String[] args) {
		new menumoi();
	}
}
