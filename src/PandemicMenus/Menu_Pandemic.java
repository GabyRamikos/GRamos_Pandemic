package PandemicMenus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu_Pandemic extends JFrame {

	public Menu_Pandemic() {
		super("Menú del juego");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Panel_menu_pricipal panel1 = new Panel_menu_pricipal();
		add(panel1);
		setBounds(0,0,1550,850);
		setVisible(true);
	}

}
