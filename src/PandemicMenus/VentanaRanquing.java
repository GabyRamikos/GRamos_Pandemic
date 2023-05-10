package PandemicMenus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaRanquing extends JPanel implements ActionListener {
	
	JTextField textField;
	private Dimension screenSize;
	private JLabel labelFondo;
	VentanaRanquing() {

		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		
		setLayout(null);
		setPreferredSize(screenSize);
	
		addButton("Salir.png",810, 650);

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
		add(button); // Agregar el botón creado al panel principal
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == getComponent(0)) {
			JFrame VentanaLogin = (JFrame) SwingUtilities.getWindowAncestor(this);
			VentanaLogin.remove(this);
			VentanaLogin.add(new Panel_menu_pricipal());
			VentanaLogin.setVisible(true);
		}

	}

}
