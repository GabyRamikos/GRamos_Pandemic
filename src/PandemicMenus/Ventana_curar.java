package PandemicMenus;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Ventana_curar extends JFrame implements ActionListener {

	JButton curar, vacunar, salir;

	public void Ventana_curar() {

		this.setUndecorated(true);
		this.setBounds(400, 200, 800, 400);
		this.setVisible(true);

		this.setResizable(false);

		curar = new JButton(new ImageIcon("negro.png"));
		curar.setBounds(30, 30, 15, 15);
		curar.addActionListener((ActionListener) this);
		this.add(curar);
		vacunar = new JButton(new ImageIcon("amarillo.png"));
		vacunar.setBounds(60, 60, 15, 15);
		vacunar.addActionListener((ActionListener) this);
		this.add(vacunar);
		salir = new JButton(new ImageIcon("azul.png"));
		salir.setBounds(90, 90, 15, 15);
		salir.addActionListener((ActionListener) this);
		this.add(salir);

		this.setLocation(null);
		this.setVisible(true);

	}

	/*
	 * private void addButton(int x, int y) {
	 * 
	 * JButton button = new JButton(new ImageIcon(imageName)); Dimension size = new
	 * Dimension(x, y); button.setPreferredSize(size);
	 * button.addActionListener((ActionListener) this); this.add(button); // Agregar
	 * el botón creado al panel principal }
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == salir) {

			setDefaultCloseOperation(EXIT_ON_CLOSE);

		}

	}

}