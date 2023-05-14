package PandemicMenus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class panelJuego extends JPanel implements ActionListener {

	JPanel titlulo;
	JTextField textField;
	private Dimension screenSize;
	private JLabel labelFondo;
	JButton sanFrancisco, Chicago, Atlanta, Montreal, NuevaYork, Washington, Londres, Madrid, Paris, Essen, Milan,
			SanPetersburgo;
	JButton LosAngeles, Miami, MexicoDF, Bogota, Lima, SantiagoDeChile, BuenosAires, SaoPaulo, Lagos, Kinsasa, Jartum,
			Johannesburgo;
	JButton Argel, ElCairo, Riad, Estambul, Bagdad, Moscu, Teheran, Karachi, Bombay, NuevaDelhi, Calcuta, Madras;
	JButton Yakarta, Bangkok, HongKong, Shanghai, Pekin, Seul, Tokio, Osaka, Taipei, HoChiMinh, Manila, Sidney;

	private int contador;
	private JProgressBar barraRoja, barraNegra, barraAmarilla, barraAzul;

	panelJuego() {

		JProgressBar barraVacunasInfeccion0 = new JProgressBar();
		barraVacunasInfeccion0.setStringPainted(true);
		barraVacunasInfeccion0.setBounds(10, 10, 150, 25);
		barraVacunasInfeccion0.setForeground(Color.BLUE);
		barraVacunasInfeccion0.setName("Alfa");
		add(barraVacunasInfeccion0);
		JButton botonInvestigar0 = new JButton("Investigar");
		botonInvestigar0.setBounds(10, 40, 150, 25);
		add(botonInvestigar0);
		botonInvestigar0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valorActual = barraVacunasInfeccion0.getValue();
				barraVacunasInfeccion0.setValue(valorActual + 25);
			}
		});
		
		JProgressBar barraVacunasInfeccion1 = new JProgressBar();
		barraVacunasInfeccion1.setStringPainted(true);
		barraVacunasInfeccion1.setBounds(170, 10, 150, 25);
		barraVacunasInfeccion1.setForeground(Color.RED);
		barraVacunasInfeccion1.setName("Beta");
		add(barraVacunasInfeccion1);
		JButton botonInvestigar1 = new JButton("Investigar");
		botonInvestigar1.setBounds(170, 40, 150, 25);
		add(botonInvestigar1);
		botonInvestigar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valorActual = barraVacunasInfeccion1.getValue();
				barraVacunasInfeccion1.setValue(valorActual + 25);
			}
		});

		JProgressBar barraVacunasInfeccion2 = new JProgressBar();
		barraVacunasInfeccion2.setStringPainted(true);
		barraVacunasInfeccion2.setBounds(330, 10, 150, 25);
		barraVacunasInfeccion2.setForeground(Color.BLACK);
		barraVacunasInfeccion2.setName("Gamma");
		add(barraVacunasInfeccion2);
		JButton botonInvestigar2 = new JButton("Investigar");
		botonInvestigar2.setBounds(330, 40, 150, 25);
		add(botonInvestigar2);
		botonInvestigar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valorActual = barraVacunasInfeccion2.getValue();
				barraVacunasInfeccion2.setValue(valorActual + 25);
			}
		});

		JProgressBar barraVacunasInfeccion3 = new JProgressBar();
		barraVacunasInfeccion3.setStringPainted(true);
		barraVacunasInfeccion3.setBounds(490, 10, 150, 25);
		barraVacunasInfeccion3.setForeground(Color.YELLOW);
		barraVacunasInfeccion3.setName("Pinocho");
		add(barraVacunasInfeccion3);
		JButton botonInvestigar3 = new JButton("Investigar");
		botonInvestigar3.setBounds(490, 40, 150, 25);
		add(botonInvestigar3);
		botonInvestigar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valorActual = barraVacunasInfeccion3.getValue();
				barraVacunasInfeccion3.setValue(valorActual + 25);
			}
		});
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);

		setLayout(null);
		setPreferredSize(screenSize);

		ImageIcon imagenCiudadAzul = new ImageIcon("azul.png");
		ImageIcon imagenCiudadAmarillo = new ImageIcon("amarillo.png");
		ImageIcon imagenCiudadNegro = new ImageIcon("negro.png");
		ImageIcon imagenCiudadRojo = new ImageIcon("rojo.png");

		sanFrancisco = new JButton(imagenCiudadAzul);
		sanFrancisco.setBounds(235, 423, 35, 35);
		add(sanFrancisco);
		sanFrancisco.setOpaque(false);
		sanFrancisco.setContentAreaFilled(false);
		sanFrancisco.setBorderPainted(false);
		sanFrancisco.addActionListener(this);

		Chicago = new JButton(imagenCiudadAzul);
		Chicago.setBounds(341, 379, 35, 35);
		add(Chicago);
		Chicago.setOpaque(false);
		Chicago.setContentAreaFilled(false);
		Chicago.setBorderPainted(false);
		Chicago.addActionListener(this);

		Atlanta = new JButton(imagenCiudadAzul);
		Atlanta.setBounds(363, 409, 35, 35);
		add(Atlanta);
		Atlanta.setOpaque(false);
		Atlanta.setContentAreaFilled(false);
		Atlanta.setBorderPainted(false);
		Atlanta.addActionListener(this);

		Montreal = new JButton(imagenCiudadAzul);
		Montreal.setBounds(403, 325, 35, 35);
		add(Montreal);
		Montreal.setOpaque(false);
		Montreal.setContentAreaFilled(false);
		Montreal.setBorderPainted(false);
		Montreal.addActionListener(this);

		NuevaYork = new JButton(imagenCiudadAzul);
		NuevaYork.setBounds(398, 356, 35, 35);
		add(NuevaYork);
		NuevaYork.setOpaque(false);
		NuevaYork.setContentAreaFilled(false);
		NuevaYork.setBorderPainted(false);
		NuevaYork.addActionListener(this);

		Washington = new JButton(imagenCiudadAzul);
		Washington.setBounds(195, 330, 35, 35);
		add(Washington);
		Washington.setOpaque(false);
		Washington.setContentAreaFilled(false);
		Washington.setBorderPainted(false);
		Washington.addActionListener(this);

		Londres = new JButton(imagenCiudadAzul);
		Londres.setBounds(700, 292, 35, 35);
		add(Londres);
		Londres.setOpaque(false);
		Londres.setContentAreaFilled(false);
		Londres.setBorderPainted(false);
		Londres.addActionListener(this);

		Madrid = new JButton(imagenCiudadAzul);
		Madrid.setBounds(690, 360, 35, 35);
		add(Madrid);
		Madrid.setOpaque(false);
		Madrid.setContentAreaFilled(false);
		Madrid.setBorderPainted(false);
		Madrid.addActionListener(this);

		Paris = new JButton(imagenCiudadAzul);
		Paris.setBounds(724, 321, 35, 35);
		add(Paris);
		Paris.setOpaque(false);
		Paris.setContentAreaFilled(false);
		Paris.setBorderPainted(false);
		Paris.addActionListener(this);

		Essen = new JButton(imagenCiudadAzul);
		Essen.setBounds(762, 296, 35, 35);
		add(Essen);
		Essen.setOpaque(false);
		Essen.setContentAreaFilled(false);
		Essen.setBorderPainted(false);
		Essen.addActionListener(this);

		Milan = new JButton(imagenCiudadAzul);
		Milan.setBounds(762, 322, 35, 35);
		add(Milan);
		Milan.setOpaque(false);
		Milan.setContentAreaFilled(false);
		Milan.setBorderPainted(false);
		Milan.addActionListener(this);

		SanPetersburgo = new JButton(imagenCiudadAzul);
		SanPetersburgo.setBounds(870, 250, 35, 35);
		add(SanPetersburgo);
		SanPetersburgo.setOpaque(false);
		SanPetersburgo.setContentAreaFilled(false);
		SanPetersburgo.setBorderPainted(false);
		SanPetersburgo.addActionListener(this);

		// Los Angeles
		LosAngeles = new JButton(imagenCiudadAmarillo);
		LosAngeles.setBounds(205, 361, 30, 30);
		add(LosAngeles);
		LosAngeles.setOpaque(false);
		LosAngeles.setContentAreaFilled(false);
		LosAngeles.setBorderPainted(false);
		LosAngeles.addActionListener(this);

		// Miami
		Miami = new JButton(imagenCiudadAmarillo);
		Miami.setBounds(362, 414, 30, 30);
		add(Miami);
		Miami.setOpaque(false);
		Miami.setContentAreaFilled(false);
		Miami.setBorderPainted(false);
		Miami.addActionListener(this);

		// Mexico DF
		MexicoDF = new JButton(imagenCiudadAmarillo);
		MexicoDF.setBounds(280, 453, 30, 30);
		add(MexicoDF);
		MexicoDF.setOpaque(false);
		MexicoDF.setContentAreaFilled(false);
		MexicoDF.setBorderPainted(false);
		MexicoDF.addActionListener(this);

		// Bogota
		Bogota = new JButton(imagenCiudadAmarillo);
		Bogota.setBounds(390, 517, 30, 30);
		add(Bogota);
		Bogota.setOpaque(false);
		Bogota.setContentAreaFilled(false);
		Bogota.setBorderPainted(false);
		Bogota.addActionListener(this);

		// Lima
		Lima = new JButton(imagenCiudadAmarillo);
		Lima.setBounds(380, 590, 30, 30);
		add(Lima);
		Lima.setOpaque(false);
		Lima.setContentAreaFilled(false);
		Lima.setBorderPainted(false);
		Lima.addActionListener(this);

		// Santiago de Chile
		SantiagoDeChile = new JButton(imagenCiudadAmarillo);
		SantiagoDeChile.setBounds(400, 715, 30, 30);
		add(SantiagoDeChile);
		SantiagoDeChile.setOpaque(false);
		SantiagoDeChile.setContentAreaFilled(false);
		SantiagoDeChile.setBorderPainted(false);
		SantiagoDeChile.addActionListener(this);

		// Buenos Aires
		BuenosAires = new JButton(imagenCiudadAmarillo);
		BuenosAires.setBounds(465, 705, 30, 30);
		add(BuenosAires);
		BuenosAires.setOpaque(false);
		BuenosAires.setContentAreaFilled(false);
		BuenosAires.setBorderPainted(false);
		BuenosAires.addActionListener(this);

		// Sao Paulo
		SaoPaulo = new JButton(imagenCiudadAmarillo);
		SaoPaulo.setBounds(520, 643, 30, 30);
		add(SaoPaulo);
		SaoPaulo.setOpaque(false);
		SaoPaulo.setContentAreaFilled(false);
		SaoPaulo.setBorderPainted(false);
		SaoPaulo.addActionListener(this);

		// Lagos
		Lagos = new JButton(imagenCiudadAmarillo);
		Lagos.setBounds(760, 500, 30, 30);
		add(Lagos);
		Lagos.setOpaque(false);
		Lagos.setContentAreaFilled(false);
		Lagos.setBorderPainted(false);
		Lagos.addActionListener(this);

		Kinsasa = new JButton(imagenCiudadAmarillo);
		Kinsasa.setBounds(792, 561, 30, 30);
		add(Kinsasa);
		Kinsasa.setOpaque(false);
		Kinsasa.setContentAreaFilled(false);
		Kinsasa.setBorderPainted(false);
		Kinsasa.addActionListener(this);

		Jartum = new JButton(imagenCiudadAmarillo);
		Jartum.setBounds(864, 442, 30, 30);
		add(Jartum);
		Jartum.setOpaque(false);
		Jartum.setContentAreaFilled(false);
		Jartum.setBorderPainted(false);
		Jartum.addActionListener(this);

		Johannesburgo = new JButton(imagenCiudadAmarillo);
		Johannesburgo.setBounds(852, 661, 30, 30);
		add(Johannesburgo);
		Johannesburgo.setOpaque(false);
		Johannesburgo.setContentAreaFilled(false);
		Johannesburgo.setBorderPainted(false);
		Johannesburgo.addActionListener(this);

		Argel = new JButton(imagenCiudadNegro);
		Argel.setBounds(725, 390, 30, 30);
		add(Argel);
		Argel.setOpaque(false);
		Argel.setContentAreaFilled(false);
		Argel.setBorderPainted(false);
		Argel.addActionListener(this);

		ElCairo = new JButton(imagenCiudadNegro);
		ElCairo.setBounds(840, 42, 30, 30);
		add(ElCairo);
		ElCairo.setOpaque(false);
		ElCairo.setContentAreaFilled(false);
		ElCairo.setBorderPainted(false);
		ElCairo.addActionListener(this);

		Riad = new JButton(imagenCiudadNegro);
		Riad.setBounds(914, 430, 30, 30);
		add(Riad);
		Riad.setOpaque(false);
		Riad.setContentAreaFilled(false);
		Riad.setBorderPainted(false);
		Riad.addActionListener(this);

		Estambul = new JButton(imagenCiudadNegro);
		Estambul.setBounds(850, 360, 30, 30);
		add(Estambul);
		Estambul.setOpaque(false);
		Estambul.setContentAreaFilled(false);
		Estambul.setBorderPainted(false);
		Estambul.addActionListener(this);

		Bagdad = new JButton(imagenCiudadNegro);
		Bagdad.setBounds(290, 400, 30, 30);
		add(Bagdad);
		Bagdad.setOpaque(false);
		Bagdad.setContentAreaFilled(false);
		Bagdad.setBorderPainted(false);
		Bagdad.addActionListener(this);

		Moscu = new JButton(imagenCiudadNegro);
		Moscu.setBounds(940, 197, 30, 30);
		add(Moscu);
		Moscu.setOpaque(false);
		Moscu.setContentAreaFilled(false);
		Moscu.setBorderPainted(false);
		Moscu.addActionListener(this);

		Teheran = new JButton(imagenCiudadNegro);
		Teheran.setBounds(975, 400, 30, 30);
		add(Teheran);
		Teheran.setOpaque(false);
		Teheran.setContentAreaFilled(false);
		Teheran.setBorderPainted(false);
		Teheran.addActionListener(this);

		Karachi = new JButton(imagenCiudadNegro);
		Karachi.setBounds(1014, 430, 30, 30);
		add(Karachi);
		Karachi.setOpaque(false);
		Karachi.setContentAreaFilled(false);
		Karachi.setBorderPainted(false);
		Karachi.addActionListener(this);

		Bombay = new JButton(imagenCiudadNegro);
		Bombay.setBounds(1040, 460, 30, 30);
		add(Bombay);
		Bombay.setOpaque(false);
		Bombay.setContentAreaFilled(false);
		Bombay.setBorderPainted(false);
		Bombay.addActionListener(this);

		NuevaDelhi = new JButton(imagenCiudadNegro);
		NuevaDelhi.setBounds(1065, 450, 30, 30);
		add(NuevaDelhi);
		NuevaDelhi.setOpaque(false);
		NuevaDelhi.setContentAreaFilled(false);
		NuevaDelhi.setBorderPainted(false);
		NuevaDelhi.addActionListener(this);

		Calcuta = new JButton(imagenCiudadNegro);
		Calcuta.setBounds(1087, 460, 30, 30);
		add(Calcuta);
		Calcuta.setOpaque(false);
		Calcuta.setContentAreaFilled(false);
		Calcuta.setBorderPainted(false);
		Calcuta.addActionListener(this);

		Madras = new JButton(imagenCiudadNegro);
		Madras.setBounds(1065, 490, 30, 30);
		add(Madras);
		Madras.setOpaque(false);
		Madras.setContentAreaFilled(false);
		Madras.setBorderPainted(false);
		Madras.addActionListener(this);

		Yakarta = new JButton(imagenCiudadRojo);
		Yakarta.setBounds(1150, 525, 30, 30);
		add(Yakarta);
		Yakarta.setOpaque(false);
		Yakarta.setContentAreaFilled(false);
		Yakarta.setBorderPainted(false);
		Yakarta.addActionListener(this);

		Bangkok = new JButton(imagenCiudadRojo);
		Bangkok.setBounds(1120, 415, 30, 30);
		add(Bangkok);
		Bangkok.setOpaque(false);
		Bangkok.setContentAreaFilled(false);
		Bangkok.setBorderPainted(false);
		Bangkok.addActionListener(this);

		HongKong = new JButton(imagenCiudadRojo);
		HongKong.setBounds(1165, 370, 30, 30);
		add(HongKong);
		HongKong.setOpaque(false);
		HongKong.setContentAreaFilled(false);
		HongKong.setBorderPainted(false);
		HongKong.addActionListener(this);

		Shanghai = new JButton(imagenCiudadRojo);
		Shanghai.setBounds(1195, 355, 30, 30);
		add(Shanghai);
		Shanghai.setOpaque(false);
		Shanghai.setContentAreaFilled(false);
		Shanghai.setBorderPainted(false);
		Shanghai.addActionListener(this);

		Pekin = new JButton(imagenCiudadRojo);
		Pekin.setBounds(1175, 300, 30, 30);
		add(Pekin);
		Pekin.setOpaque(false);
		Pekin.setContentAreaFilled(false);
		Pekin.setBorderPainted(false);
		Pekin.addActionListener(this);

		Seul = new JButton(imagenCiudadRojo);
		Seul.setBounds(1225, 297, 30, 30);
		add(Seul);
		Seul.setOpaque(false);
		Seul.setContentAreaFilled(false);
		Seul.setBorderPainted(false);
		Seul.addActionListener(this);

		Tokio = new JButton(imagenCiudadRojo);
		Tokio.setBounds(1280, 290, 30, 30);
		add(Tokio);
		Tokio.setOpaque(false);
		Tokio.setContentAreaFilled(false);
		Tokio.setBorderPainted(false);
		Tokio.addActionListener(this);

		Osaka = new JButton(imagenCiudadRojo);
		Osaka.setBounds(1255, 320, 30, 30);
		add(Osaka);
		Osaka.setOpaque(false);
		Osaka.setContentAreaFilled(false);
		Osaka.setBorderPainted(false);
		Osaka.addActionListener(this);

		Taipei = new JButton(imagenCiudadRojo);
		Taipei.setBounds(1205, 375, 30, 30);
		add(Taipei);
		Taipei.setOpaque(false);
		Taipei.setContentAreaFilled(false);
		Taipei.setBorderPainted(false);
		Taipei.addActionListener(this);

		HoChiMinh = new JButton(imagenCiudadRojo);
		HoChiMinh.setBounds(1148, 429, 30, 30);
		add(HoChiMinh);
		HoChiMinh.setOpaque(false);
		HoChiMinh.setContentAreaFilled(false);
		HoChiMinh.setBorderPainted(false);
		HoChiMinh.addActionListener(this);

		Manila = new JButton(imagenCiudadRojo);
		Manila.setBounds(1148, 429, 30, 30);
		add(Manila);
		Manila.setOpaque(false);
		Manila.setContentAreaFilled(false);
		Manila.setBorderPainted(false);
		Manila.addActionListener(this);

		Sidney = new JButton(imagenCiudadRojo);
		Sidney.setBounds(1320, 645, 30, 30);
		add(Sidney);
		Sidney.setOpaque(false);
		Sidney.setContentAreaFilled(false);
		Sidney.setBorderPainted(false);
		Sidney.addActionListener(this);

		ImageIcon imagenFondo = new ImageIcon("mapa_mundo.png");
		labelFondo = new JLabel(imagenFondo);
		labelFondo.setBounds(0, 0, screenSize.width, screenSize.height);
		add(labelFondo);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == sanFrancisco) {

			// explicació funcionament botó
			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);

		} else if (e.getSource() == Chicago) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Atlanta) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Montreal) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == NuevaYork) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Washington) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Londres) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Madrid) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Paris) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Essen) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Milan) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == SanPetersburgo) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == LosAngeles) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Miami) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == MexicoDF) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Bogota) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Lima) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == SantiagoDeChile) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == BuenosAires) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == SaoPaulo) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Lagos) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Kinsasa) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Jartum) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Johannesburgo) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Argel) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == ElCairo) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Riad) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Estambul) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Bagdad) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Moscu) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Teheran) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Karachi) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Bombay) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == NuevaDelhi) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Calcuta) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Madras) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Yakarta) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Bangkok) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == HongKong) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Shanghai) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Pekin) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Seul) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Tokio) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Osaka) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Taipei) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == HoChiMinh) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Manila) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		} else if (e.getSource() == Sidney) {

			Ventana_curar panel_Curar = new Ventana_curar();
			panel_Curar.Ventana_curar();
			sanFrancisco.add(panel_Curar);
		}
	}
}