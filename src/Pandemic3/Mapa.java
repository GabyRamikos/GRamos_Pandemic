package Pandemic3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Mapa {
    private Ciudad[][] ciudades;
    private Map<Ciudad, Set<Ciudad>> conexiones;
    private Enfermedad[] enfermedades;
    
    public Ciudad[][] getCiudades() {
        return this.ciudades;
    }
    
    public List<Ciudad> getCiudades2() {
        List<Ciudad> listaCiudad = new ArrayList<>();
        for (Ciudad[] fila : ciudades) {
            for (Ciudad ciudad : fila) {
            	listaCiudad.add(ciudad);
            }
        }
        return listaCiudad;
    }

    // Constructor para obtener las ciudades vecinas de la ciudad actual
    public Map<Ciudad, Set<Ciudad>> getConexiones() {
        return this.conexiones;
    }
    
    public Enfermedad[] getEnfermedades() {
		return this.enfermedades;
	}
    
    // Constructor para obtener la ciudad actual del jugador
    public Ciudad getCiudadEn(int x, int y) {
        return ciudades[x][y];
    }

    // Método para el cálculo de la distancia sobre las coordenadas de cada ciudad
    private int calcularDistancia(Ciudad ciudad1, Ciudad ciudad2) {
        int dx = ciudad1.getCoordenadasX() - ciudad2.getCoordenadasX();
        int dy = ciudad1.getCoordenadasY() - ciudad2.getCoordenadasY();
        return (int) Math.sqrt(dx*dx + dy*dy);
    }
    
    // Método que genera una ciudad aleatoria
   	public Ciudad getCiudadAleatoria() {
   		List<Ciudad> ciudades = Ciudad.leerCiudades();
           Random random = new Random();
           return ciudades.get(random.nextInt(ciudades.size()));
   	}
   	
   	// Método que incrementa los brotes por nivel de propagación por ciudad
   	public int incrementarBrotesPorCiudadesEnNivel(int nivel) {
   	    int brotesAdicionales = 0;
   	    for (Ciudad ciudad : getCiudades2()) {
   	        if (!ciudad.isInfectada() && ciudad.getNivelEnfermedadTotal() >= nivel) {
   	            ciudad.infectar();
   	            brotesAdicionales++;
   	        }
   	    }
   	    return brotesAdicionales;
   	}

    // Método para obtener las ciudades colidantes de una ciudad dada
    public List<Ciudad> getCiudadesColindantes(Ciudad ciudad) {
        List<Ciudad> colindantes = new ArrayList<>();
        for (String nombreCiudad : ciudad.getCiudadesColindantes()) {
            for (int i = 0; i < ciudades.length; i++) {
                for (int j = 0; j < ciudades[i].length; j++) {
                    Ciudad ciudadColindante = ciudades[i][j];
                    if (ciudadColindante != null && ciudadColindante.getNombre().equals(nombreCiudad)) {
                        colindantes.add(ciudadColindante);
                    }
                }
            }
        }
        return colindantes;
    }
    
    public Mapa() {
        this(9); // Método que inicializa el número de ciudades infectadas al inicio de la partida en 9
    }
    
    // Método que recorre el número de ciudades infectadas al inicio de la partida
    public Mapa(int ciudadesInfectadas) {
        List<Ciudad> listaCiudades = Ciudad.leerCiudades();
        this.ciudades = new Ciudad[listaCiudades.size()][listaCiudades.size()];
        this.conexiones = new HashMap<>();
        for (Ciudad ciudad : listaCiudades) {
            conexiones.put(ciudad, new HashSet<>());
        }
        for (int i = 0; i < listaCiudades.size(); i++) {
            for (int j = i + 1; j < listaCiudades.size(); j++) {
                Ciudad ciudad1 = listaCiudades.get(i);
                Ciudad ciudad2 = listaCiudades.get(j);
                if (calcularDistancia(ciudad1, ciudad2) <= 100) {
                    conexiones.get(ciudad1).add(ciudad2);
                    conexiones.get(ciudad2).add(ciudad1);
                }
            }
        }
        for (Ciudad ciudad : listaCiudades) {
            ciudades[ciudad.getCoordenadasX()][ciudad.getCoordenadasX()] = ciudad;
        }
        
        // Inicializar ciudades infectadas al inicio de la partida
        List<Ciudad> ciudadesInfectadas1 = new ArrayList<>();
        int numeroCiudadesInfectadas1 = 9; // número de ciudades infectadas al inicio del juego
        Random random = new Random();
        while (ciudadesInfectadas1.size() < numeroCiudadesInfectadas1) {
            Ciudad ciudadAleatoria = listaCiudades.get(random.nextInt(listaCiudades.size()));
            if (!ciudadesInfectadas1.contains(ciudadAleatoria)) {
                ciudadAleatoria.setNivelEnfermedad(enfermedades[0], 1);
                ciudadesInfectadas1.add(ciudadAleatoria);
            }
        }
        
    }
    
    public List<Ciudad> getCiudadesConEnfermedad(Enfermedad enfermedad) {
        List<Ciudad> ciudadesConEnfermedad = new ArrayList<>();
        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < ciudades[i].length; j++) {
                Ciudad ciudad = ciudades[i][j];
                if (ciudad != null && ciudad.getNivelEnfermedad(enfermedad) > 0) {
                    ciudadesConEnfermedad.add(ciudad);
                }
            }
        }
        return ciudadesConEnfermedad;
    }

}