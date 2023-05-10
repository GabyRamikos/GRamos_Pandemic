package PandemicMenus;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.geom.*;
import java.awt.image.BufferedImage;

	public class BotonesCiudades extends JButton {
		
	   public BotonesCiudades(String cityName, String imagePath) {
	      super(cityName);
	      
	      // Cargar la imagen y redimensionarla a 15x15px
	      ImageIcon imageIcon = new ImageIcon(imagePath);
	      Image image = imageIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	      
	      // Crear una forma elíptica para el botón
	      Shape shape = new Ellipse2D.Float(0, 0, 15, 15);
	      
	      // Crear un icono con forma para el botón
	      ImageIcon roundIcon = new ImageIcon(getRoundImage(image, shape));
	      
	      // Establecer el icono de fondo del botón
	      setIcon(roundIcon);
	      
	      // Establecer el tamaño del botón
	      setPreferredSize(new Dimension(15, 15));
	      
	      // Desactivar cualquier borde del botón
	      setBorderPainted(false);
	      setFocusPainted(false);
	      setContentAreaFilled(false);
	   }
	   
	   // Método para crear una imagen redonda a partir de una imagen rectangular
	   private static Image getRoundImage(Image image, Shape shape) {
	      BufferedImage roundedImage = new BufferedImage(15, 15, BufferedImage.TYPE_INT_ARGB);
	      Graphics2D g2d = roundedImage.createGraphics();
	      g2d.setClip(shape);
	      g2d.drawImage(image, 0, 0, null);
	      g2d.dispose();
	      return roundedImage;
	   }
	}


