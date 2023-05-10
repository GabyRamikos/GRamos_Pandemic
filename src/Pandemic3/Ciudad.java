package Pandemic3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ciudad {
	private String nombre;
	private int coordenadaX;
	private int coordenadaY;
	private List<String> ciudadesColindantes;
	private boolean centroInvestigacion;
	private int puntosAccion;
	private Map<Enfermedad, Integer> enfermedades = new HashMap<>();
	private boolean infectada = false;
	private static int[] nivelesEnfermedades;

	public Ciudad(String nombre, int coordenadaX, int coordenadaY, List<String> ciudadesColindantes, int puntosAccion,
			int[] nivelesEnfermedades) {
		this.nombre = nombre;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.ciudadesColindantes = ciudadesColindantes;
		this.puntosAccion = puntosAccion;
		this.nivelesEnfermedades = nivelesEnfermedades;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCoordenadasX() {
		return coordenadaX;
	}

	public int getCoordenadasY() {
		return coordenadaY;
	}

	public List<String> getCiudadesColindantes() {
		return ciudadesColindantes;
	}

	public boolean tieneConexion(Ciudad otraCiudad) {
		return ciudadesColindantes.contains(otraCiudad.getNombre());
	}

	public boolean tieneCentroInvestigacion() {
		return centroInvestigacion;
	}

	public boolean construirCentroInvestigacion() {
		if (!tieneCentroInvestigacion() && puntosAccion > 0) {
			centroInvestigacion = true;
			restarPuntoAccion();
			return true;
		}
		return false;
	}

	public void restarPuntoAccion() {
		puntosAccion--;
	}

	public Enfermedad getEnfermedadActiva() {
		// Recorre todas las enfermedades de la ciudad
		for (Enfermedad enfermedad : enfermedades.keySet()) {
			// Si la enfermedad tiene un nivel mayor a cero estará activa
			if (enfermedades.get(enfermedad) > 0) {
				return enfermedad;
			}
		}
		return null; // Si no hay enfermedades activas, no devuelve nada
	}

	public int getNivelEnfermedad(Enfermedad enfermedad) {
		// Devuelve el nivel de propagación de la enfermedad en la ciudad
		// Si no hay enfermedad, devuelve 0
		return enfermedades.containsKey(enfermedad) ? enfermedades.get(enfermedad) : 0;
	}

	public int getNivelEnfermedadTotal() {
		int nivelTotal = 0;
		// Recorre todas las enfermedades de la ciudad
		for (int nivelEnfermedad : enfermedades.values()) {
			nivelTotal += nivelEnfermedad;
		}
		return nivelTotal;
	}

	// Establece un nivel especifíco de la propagación de la enfermedad para una
	// ciudad
	public void setNivelEnfermedad(Enfermedad enfermedad, int nivel) {
		if (enfermedades.containsKey(enfermedad)) {
			enfermedades.put(enfermedad, nivel);
		} else {
			enfermedades.put(enfermedad, 0);
		}
	}

	public void aumentarNivelEnfermedad(Enfermedad enfermedad, int cantidad) {
		// Aumenta el nivel de propagación de la enfermedad en la ciudad
		int nivel = getNivelEnfermedad(enfermedad);
		enfermedades.put(enfermedad, nivel + cantidad);
	}

	public void disminuirNivelEnfermedad(Enfermedad enfermedad) {
		// Disminuye el nivel de propagación de la enfermedad en la ciudad
		int nivel = getNivelEnfermedad(enfermedad);
		if (nivel > 0) {
			enfermedades.put(enfermedad, nivel - 1);
		}
	}

	public boolean isInfectada() {
		return infectada; // Retorna valor de la variable iniciada en false
	}

	public void infectar() {
		infectada = true; // Modifica el valor de la variable a true
	}

	public void setInfectada(boolean valor) {
		infectada = valor;
	}

	public void resetNivelesEnfermedades() {
		Arrays.fill(nivelesEnfermedades, 0);
		infectada = false;
	}

	// Método para leer las ciudades del archivo "ciudades.txt"
	public static List<Ciudad> leerCiudades() {
		List<Ciudad> ciudades = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("ciudades.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(";");
				String nombre = partes[0];
				int coordenadaX = Integer.parseInt(partes[2].split(",")[0]);
				int coordenadaY = Integer.parseInt(partes[2].split(",")[1]);
				String[] ciudadesColindantes = partes[3].split(",");
				List<String> ciudadesColindantesList = new ArrayList<>();
				for (String ciudad : ciudadesColindantes) {
					ciudadesColindantesList.add(ciudad);
				}
				ciudades.add(
						new Ciudad(nombre, coordenadaX, coordenadaY, ciudadesColindantesList, 0, nivelesEnfermedades));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ciudades;
	}
}