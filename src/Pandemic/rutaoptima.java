package Pandemic;

import java.util.*;

public class rutaoptima {
	
	// Clase Ciudad1 con la información de las ciudades
		static class Ciudad1 {
		    String ciudad;
		    String[] ciudades;
		    int[][] ciudadCoordenadas;

			// Constructor creado dentro de la clase
		    public Ciudad1(String ciudad, String[] ciudades, int[][] ciudadCoordenadas) {
		        this.ciudad = ciudad;
		        this.ciudades = ciudades;
		        this.ciudadCoordenadas = ciudadCoordenadas;
		    }
		}
		
		// Método principal
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);

	        // Solicitar nombre de la ciudad
	        System.out.println("Ingrese el nombre de la ciudad: ");
	        String ciudad = scanner.nextLine();

	        // Solicitar lista de ciudades
	        System.out.println("Ingrese las ciudades separadas por coma (,): ");
	        String ciudadesInput = scanner.nextLine();
	        String[] ciudades = ciudadesInput.split(",");

	        // Coordenadas de cada ciudad
	        int[][] ciudadCoordenadas = { { 0, 0 }, { 384, 427 }, { 115, 678 }, { 135, 864 }, { 150, 231 } };

	        Ciudad1 ciudadInicial = new Ciudad1(ciudad, ciudades, ciudadCoordenadas);
	        rutaOptima(ciudadInicial);

	        scanner.close();
		}	
		
		
	//************************************************************************************
	//** Nombre de la función: rutaOptima()
	//** Tipo de modificador de la función: public static -- Utilizado porque puede usarse dicha función en cualquier parte del código.
	//** Explicación del que hace la función: Función que calcula la ruta óptima desde la ciudad dada hasta todas las demás ciudades
	//** Parámetros de entrada: Objeto -- Recibe el objeto ciudadInicial
	//** Parámetros de salida: void -- No devuelve ningún valor.
	//************************************************************************************
	public static void rutaOptima(Ciudad1 ciudadInicial) {
		// Creación de las diferentes ariables
		int numCiudades = ciudadInicial.ciudades.length; // número de ciudades
		int[][] grafo = new int[numCiudades][numCiudades]; // matriz de adyacencia
		int[] distancias = new int[numCiudades]; // matriz de distancias
		boolean[] visitados = new boolean[numCiudades]; // matriz de ciudades visitados
		PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>(); // cola de prioridad

		// Inicialización de la matriz de adyacencia con distancias entre ciudades
		for (int i = 0; i < numCiudades; i++) {
			for (int j = 0; j < numCiudades; j++) {
				if (i < ciudadInicial.ciudadCoordenadas.length && j < ciudadInicial.ciudadCoordenadas.length) {
				int x1 = ciudadInicial.ciudadCoordenadas[i][0];
				int y1 = ciudadInicial.ciudadCoordenadas[i][1];
				int x2 = ciudadInicial.ciudadCoordenadas[j][0];
				int y2 = ciudadInicial.ciudadCoordenadas[j][1];
				grafo[i][j] = (int) Math.round(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
				}
			}
		}

		// Inicialización de la matriz de distancias con valor infinito
		Arrays.fill(distancias, Integer.MAX_VALUE);
		distancias[0] = 0;

		// Agrega la ciudad inicial a la cola de prioridad
		colaPrioridad.add(0);

		// Bucle while que aplica el algoritmo de Dijkstra
		while (!colaPrioridad.isEmpty()) {
			int ciudadActual = colaPrioridad.poll();
			visitados[ciudadActual] = true;

			// Bucle for que actualiza las distancias de los vecinos/ciudades no visitados
			for (int i = 0; i < numCiudades; i++) {
				if (!visitados[i] && grafo[ciudadActual][i] != 0 && distancias[ciudadActual] != Integer.MAX_VALUE
						&& distancias[ciudadActual] + grafo[ciudadActual][i] < distancias[i]) {
					distancias[i] = distancias[ciudadActual] + grafo[ciudadActual][i];
					colaPrioridad.add(i);
				}
			}
		}

		// Imprime la ruta óptima para cada ciudad
		for (int i = 0; i < numCiudades; i++) {
			if (i != 0) { // Condición para saltarse la primera ciudad obtenida
				System.out.print("La ruta óptima desde " + ciudadInicial.ciudad + " hasta " + ciudadInicial.ciudades[i]
						+ " es: ");
				if (distancias[i] != Integer.MAX_VALUE) {
					System.out.println(distancias[i]);
				} else {
					System.out.println("No hay conexión directa entre las ciudades");
				}
			}
		}
	}
}
