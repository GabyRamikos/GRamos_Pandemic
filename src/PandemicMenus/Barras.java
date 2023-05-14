package PandemicMenus;

import javax.swing.*;
import java.awt.*;

public class Barras extends JPanel {

    private JProgressBar[] barras;

    public void incrementarVacuna(int indice, int cantidad) {
        barras[indice].setValue(barras[indice].getValue() + cantidad);
    }

	public void incrementarProgreso() {
		// TODO Auto-generated method stub
		
	}

	
}