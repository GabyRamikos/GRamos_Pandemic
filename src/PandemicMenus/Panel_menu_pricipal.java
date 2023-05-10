package PandemicMenus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel_menu_pricipal extends JPanel implements ActionListener {

	private JLabel labelFondo;
	private Dimension screenSize;

	Panel_menu_pricipal() {

		// Obtener el tamaño de la pantalla y establecerlo como tamaño de la ventana
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);

		// Panel principal creado con layout establecido
		setLayout(null);
		setPreferredSize(screenSize);

		// Crear los botones utilizando un método auxiliar
		addButton("Nueva partida.png", screenSize.width / 3 - 400, screenSize.height / 4 - 160);
		addButton("Cargar Partida.png", screenSize.width / 3 - 400, screenSize.height / 4);
		addButton("Puntiación.png", screenSize.width / 3 - 400, screenSize.height / 4 + 160);
		addButton("información.png", screenSize.width / 3 - 400, screenSize.height / 4 + 320);
		addButton("Autores.png", screenSize.width / 3 - 400, screenSize.height / 4 + 480);
		addButton("Versión.png", screenSize.width / 3 - 400, screenSize.height / 4 + 640);
		addButton("Salir.png", screenSize.width / 2 + 670, screenSize.height / 4 + 640);

		// Cargar la imagen de fondo
		ImageIcon imagenFondo = new ImageIcon("imagen_menu_pandemic.jpg");
		labelFondo = new JLabel(imagenFondo);
		labelFondo.setBounds(0, 0, screenSize.width, screenSize.height);
		add(labelFondo);

		// Mostrar ventana
		//setLocation(null);
		setVisible(true);
	}

	private void addButton(String imageName, int x, int y) {
		JButton button = new JButton(new ImageIcon(imageName));
		Dimension size = new Dimension(screenSize.width / 4, screenSize.height / 8);
		button.setPreferredSize(size);
		button.setBounds((int) (x * screenSize.getWidth() / 1920), (int) (y * screenSize.getHeight() / 1080),
				size.width, size.height);
		button.addActionListener((ActionListener) this);
		button.setBorder(null);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		add(button); // Agregar el botón creado al panel principal
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getComponent(0)) {
			// Acción para el botón de Nueva partida
			
			JFrame VentanaLogin = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaLogin.remove(this);
			VentanaLogin.add(new VentanaLogin());
			VentanaLogin.setVisible(true);
			

		} else if (e.getSource() == getComponent(1)) {
			// Acción para el botón de Cargar partida
			
			
		} else if (e.getSource() == getComponent(2)) {
			// Acción para acceder a la ventana del login y ver el resumen de puntajes
			JFrame VentanaLogin = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaLogin.remove(this);
			VentanaLogin.add(new VentanaLogin());
			VentanaLogin.setVisible(true);

		} else if (e.getSource() == getComponent(3)) {
			// Acción para el botón de Información
			JOptionPane.showMessageDialog(null, "Reglas del juego Pandemic:\n\n"
					+ "1. El objetivo del juego es encontrar la cura para cuatro enfermedades mortales.\n"
					+ "2. El jugador representa a un personaje con habilidades especiales.\n"
					+ "3. El jugador debe recolectar acciones de enfermedades, tratar pacientes y encontrar la cura.\n"
					+ "4. El jugador pierde si se queda sin ninguna accion sobre la enfermedad, si hay demasiadas epidemias o si no logra encontrar la cura a tiempo.\n"
					+ " ¡Buena suerte!\n", "Reglas del juego", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() ==getComponent(4)) {
			// Acción para el botón de Autores
			JOptionPane.showMessageDialog(null,
					"Autores:\n\n" + " Raul Pereira Costa \n raulpereira@hotmail.com\n"
							+ " Gabriel Ramos \n gabyramos290@gmail.com\n" + " Roger Orteu",
					"Autores", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == getComponent(5)) {
			// Acción para el botón de Versión

			JOptionPane.showMessageDialog(null, "Versión actual: 1.0", "Versión", JOptionPane.INFORMATION_MESSAGE);

		} else if (e.getSource() == getComponent(6)) {
			// Acción para el botón de Salir
			System.exit(0);
		}
	}
}
