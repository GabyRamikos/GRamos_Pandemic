package Pandemic3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Enfermedad {
	private int codigoEnfermedad;
	private String nombreEnfermedad;
	private String colorEnfermedad;
	private int nivelPropagacion;
	private boolean curada;
	private int vecesActivada;
	private int curaProgreso;

	public Enfermedad(int codigo, String nombre, String color, int nivel) {
		codigoEnfermedad = codigo;
		nombreEnfermedad = nombre;
		colorEnfermedad = color;
		nivelPropagacion = nivel;
		vecesActivada = 0;
	}

	public int getCodigoEnfermedad() {
		return codigoEnfermedad;
	}

	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}

	public String getColorEnfermedad() {
		return colorEnfermedad;
	}

	// Método de progreso de la cura
	public int avanzarCura() {
		curaProgreso++;
		if (curaProgreso == 4) {
			System.out.println("¡La enfermedad " + nombreEnfermedad + " ha sido curada!");
		}
		return curaProgreso;
	}

	public int getNivelPropagacion() {
		return nivelPropagacion;
	}

	// constructor que acepta un nivel de propagación como parámetro
	public void setNivelPropagacion(int nivel) {
		nivelPropagacion = nivel;
	}

	// Método que calcula el nivel de propagación en función de la gravedad
	// Acepta la gravedad de la enfermedad como parámetro y calcula el nivel de propagación en función de ella.
	public double calcularNivelPropagacion(double gravedad) {
		// Implementación del cálculo del nivel de propagación en función de la gravedad
		double factorGravedad = 1.0;
		if (gravedad >= 8.0) {
			factorGravedad = 1.5;
		} else if (gravedad >= 6.0) {
			factorGravedad = 1.2;
		} else if (gravedad >= 4.0) {
			factorGravedad = 1.1;
		}
		return nivelPropagacion * factorGravedad;
	}

	// Método para incrementar el contador de veces que se ha activado la enfermedad
	public void incrementarVecesActivada() {
		vecesActivada++;
	}

	// Método para obtener el contador de veces que se ha activado la enfermedad
	public int getVecesActivada() {
		return vecesActivada;
	}

	// Método que devolverá una lógica si esta curada una ciudad
	public boolean estaCurada() {
		return curada;
	}

	// Método para la afirmación de la curación de la enfermedad
	public void curarEnfermedad() {
		curada = true;
	}

	public static List<Enfermedad> leerEnfermedades() throws IOException {
		List<Enfermedad> listaEnfermedades = new ArrayList<>();

		// Abre el archivo CCP.bin para leerlo
		FileInputStream fis = new FileInputStream("CCP.bin");
		DataInputStream dis = new DataInputStream(fis);

		while (dis.available() > 0) {
			int codigoEnfermedad = dis.readInt();
			String nombreEnfermedad = dis.readUTF();
			String colorEnfermedad = dis.readUTF();
			// Crear una instancia de enfermedad con nivel de propagación 0 y agregarla a la
			// lista
			Enfermedad enfermedad = new Enfermedad(codigoEnfermedad, nombreEnfermedad, colorEnfermedad, 0);
			listaEnfermedades.add(enfermedad);
		}

		return listaEnfermedades;
	}

	@Override
	public String toString() {
		return "Enfermedad [codigoEnfermedad=" + codigoEnfermedad + ", nombreEnfermedad=" + nombreEnfermedad
				+ ", colorEnfermedad=" + colorEnfermedad + ", nivelPropagacion=" + nivelPropagacion + "]";
	}
}
