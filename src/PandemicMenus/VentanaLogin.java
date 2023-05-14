package PandemicMenus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaLogin extends JPanel implements ActionListener {

	JButton volver, okay;
	JPanel titlulo;
	JTextField textField;
	private Dimension screenSize;
	private JLabel labelFondo;

	VentanaLogin() {

		// Obtener el tamaño de la pantalla y establecerlo como tamaño de la ventana
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		
		setLayout(null);
		setPreferredSize(screenSize);
	
		addButton("Salir.png", 810, 650); // <-- Change the order of the buttons.
		addButton("okay", 810,550);

		// Crear el JLabel con el texto deseado
		JLabel label = new JLabel("Ingrese su nombre de usuario");
		label.setBounds(690, 360, 200, 30);
		add(label);

		// Crear el JTextField para ingresar el nombre de usuario
		textField = new JTextField();
		textField.setBounds(675, 400, 200, 30);
		textField.addActionListener(this);
		add(textField);
		
		ImageIcon imagenFondo = new ImageIcon("fondo-loging.jpg");
		labelFondo = new JLabel(imagenFondo);
		labelFondo.setBounds(0, 0, screenSize.width, screenSize.height);
		add(labelFondo);
		
		setVisible(true);
	}
	private void addButton(String imageName, int x, int y) {
		JButton button = new JButton(new ImageIcon(imageName));
		Dimension size = new Dimension(screenSize.width / 6, screenSize.height / 12);
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

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == getComponent(0)) {
			JFrame VentanaLogin = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaLogin.remove(this);
			VentanaLogin.add(new Panel_menu_pricipal());
			VentanaLogin.setVisible(true);
		} else if (e.getSource() == textField) {
			// Aquí puedes agregar el código para guardar la palabra escrita en la base de
			// datos y buscarla
			String nombreUsuario = textField.getText();
			

		} else if (e.getSource() == getComponent(1)) {
			JFrame VentanaLogin = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaLogin.remove(this);
			VentanaLogin.add(new panelJuego());
			VentanaLogin.setVisible(true);
			
		}
	}
}
