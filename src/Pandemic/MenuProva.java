package Pandemic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuProva extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnNewGame, btnLoadGame, btnInfo, btnScores, btnAuthors, btnVersion, btnExit;

	public MenuProva() {
	        // Configuración básica del frame
	        setTitle("Juego Pandemic");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        
	        // Creación de los botones del menú
	        btnNewGame = new JButton("Nueva partida");
	        btnLoadGame = new JButton("Cargar partida");
	        btnInfo = new JButton("Información");
	        btnScores = new JButton("Resumen de puntuaciones");
	        btnAuthors = new JButton("Autores");
	        btnVersion = new JButton("Versión");
	        btnExit = new JButton("Salir");
	        
	        // Configuración de las posiciones y tamaños de los botones
	        btnNewGame.setBounds(50, 30, 300, 30);
	        btnLoadGame.setBounds(50, 70, 300, 30);
	        btnInfo.setBounds(50, 110, 300, 30);
	        btnScores.setBounds(50, 150, 300, 30);
	        btnAuthors.setBounds(50, 190, 300, 30);
	        btnVersion.setBounds(50, 230, 300, 30);
	        btnExit.setBounds(50, 270, 300, 30);
	        
	        // Agregación de los botones al frame
	        add(btnNewGame);
	        add(btnLoadGame);
	        add(btnInfo);
	        add(btnScores);
	        add(btnAuthors);
	        add(btnVersion);
	        add(btnExit);
	        
	        // Agregación de las llamadas a los botones
	        btnNewGame.addActionListener(this);
	        btnLoadGame.addActionListener(this);
	        btnInfo.addActionListener(this);
	        btnScores.addActionListener(this);
	        btnAuthors.addActionListener(this);
	        btnVersion.addActionListener(this);
	        btnExit.addActionListener(this);
	        
	        // Hacer visible el frame
	        setVisible(true);
	    }

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewGame) {
			// Acción de nueva partida
		} else if (e.getSource() == btnLoadGame) {
			// Acción de cargar partida
		} else if (e.getSource() == btnInfo) {
			// Acción de mostrar información
			JOptionPane.showMessageDialog(this, "Un juego de tablero virtual en el que nos convertimos en "
					+ "\nmiembros de un equipo de control de enfermedades que luchan juntos por controlar y acabar con las "
					+ "\n4 temidas enfermedades que hostigan el mundo entero, poniendo en peligro a la especie humana. "
					+ "\nUn juego indiviual en el que debemos viajar entre países, acumular información de cada enfermedad "
					+ "\ne ir atacando para lograr erradicar las enfermedades, pero sobre todo nuestra misión es encontrar las "
					+ "\n4 curas que reduzca la curva de contagios. Debemos conseguirlo antes de que sea demasiado tarde…");
		} else if (e.getSource() == btnScores) {
			// Acción de mostrar resumen de puntuaciones
		} else if (e.getSource() == btnAuthors) {
			// Acción de mostrar autores
			JOptionPane.showMessageDialog(this, "Autores:\n- Gabriel Ramos\n- Raul Perreira\n- Roger Orteu");
		} else if (e.getSource() == btnVersion) {
			// Acción de mostrar versión
			JOptionPane.showMessageDialog(this, "Versión 1.0");
		} else if (e.getSource() == btnExit) {
			// Acción de salir
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new MenuProva();
	}
}
