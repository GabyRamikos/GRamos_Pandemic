package Pandemic;

import java.io.*;
import java.util.*;

import Pandemic.ciudad.Ciudad;

public class ciudades {
    public static void main(String[] args) throws IOException {
    	// Creación de las diferentes variables
    	// Crear una nueva ciudad con su nombre, coordenadas y ciudades adyacentes
    	Ciudad ciudad1 = new Ciudad ("Ciudad 1", new int[] {0, 0}, new int[][] {{1, 1}, {2, 2}});
    	Scanner sc = null; // Inicialización del scanner
        File ciudadesArchivo = new File("ciudades.txt"); // Creación del objeto que abre el archivo para leer
        FileWriter lectura = null; // Variable que lee primero el archivo para luego escribirlo
        
        // Creacion de más variables para las ciudades, coordenanadas y etc
        int distancia, x1, x2, adyacenteX1, adyacenteX2, distanciaAdyacente;
        String linea, nombre, mensaje, ciudadColidante;
        String[] partes, coordenadas, ciudadesAdyacentes, partesCiudadAdyacentes, ciudadCoordenadasAdyacentes;
        
        //Try-catch-finally para leer el archivo y determinar las distancias
        try {
            sc = new Scanner(ciudadesArchivo);
            lectura = new FileWriter("ciudadesRedactadas.txt");
            
            // Bucle con la función de calcular las distancias entre cada ciudad y ciudades adyacentes 
            while (sc.hasNextLine()) {
            	
            	// Separación de la entrada en sus componentes/partes
            	linea = sc.nextLine();
            	partes = linea.split(";");
            	nombre = partes[0];
            	distancia = Integer.parseInt(partes[1]);
            	coordenadas = partes[2].split(",");
            	x1 = Integer.parseInt(coordenadas[0]);
            	x2 = Integer.parseInt(coordenadas[1]);
            	ciudadesAdyacentes = partes[3].split(",");
            	mensaje = "La ciudad " + nombre + " está en las coordenadas (" + x1 + ", " + x2 + ") sus ciudades colidantes son: \n";
            	
            	// Bucle para recorrer las ciudades adyacentes, calcular distancias y mostrar un mensaje
            	for (String ciudadAdyacente : ciudadesAdyacentes) {
            		partesCiudadAdyacentes = ciudadAdyacente.split(" ");
            		ciudadColidante = partesCiudadAdyacentes[0];
            		ciudadCoordenadasAdyacentes = getCiudadCoordenadas(ciudadColidante, ciudadesArchivo);
            		
            		// Condición por si no puede obtener las coordenadas, se omite la ciudad adyacente
            		if (ciudadCoordenadasAdyacentes == null) {
            			continue;
            		}
            		adyacenteX1 = Integer.parseInt(ciudadCoordenadasAdyacentes[0]);
            		adyacenteX2 = Integer.parseInt(ciudadCoordenadasAdyacentes[1]);
            		distanciaAdyacente = getDistancia(x1, x2, adyacenteX1, adyacenteX2);
            		mensaje += "· " + ciudadColidante + ", que está a una distancia de "+ distanciaAdyacente + "\n" ;
            	}
            	
            	// Mostrar el contenido del mensaje de las ciudades colidantes con su rspectiva distancia
            	System.out.println(mensaje);
            	lectura.write(mensaje);
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Condinción que cierra el try catch finally
			if (sc != null) {
				sc.close();
			}
			// Condición de cierre del objeto FileWriter
			if (lectura != null) {
				try {
					lectura.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }

    //************************************************************************************
  	//** Nombre de la función: getDistancia()
  	//** Tipo de modificador de la función: private static -- Utilizado porque solo debe usarse a dicha función propia.
  	//** Explicación del que hace la función: Función con la fórmula que calcula la distancias entre ciudades
  	//** Parámetros de entrada: int -- Recibe cuatro variables de tipo entero
  	//** Parámetros de salida: int -- Devuelve un valor entero.
  	//************************************************************************************
	private static int getDistancia(int x1, int x2, int adyacenteX1, int adyacenteX2) {
		// Creacion de la variable con la devolución del cálculo
		double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(adyacenteX1 - adyacenteX2, 2));
		return (int) Math.round(distancia);
	}

	//************************************************************************************
  	//** Nombre de la función: getCiudadCoordenadas()
  	//** Tipo de modificador de la función: private static -- Utilizado porque solo debe usarse a dicha función propia.
  	//** Explicación del que hace la función: Función que recibe las entradas y los separa para las ciudades colidantes
  	//** Parámetros de entrada: String, File -- Recibe un string y el objeto archivo
  	//** Parámetros de salida: String[] -- Devuelve un valor array de string.
  	//************************************************************************************
	private static String[] getCiudadCoordenadas(String ciudadColidante, File ciudadesArchivo) throws IOException {
		// Creación de variables
		Scanner sc = new Scanner(ciudadesArchivo);
		String linia; String[] partes, coordinadas;
		
		while (sc.hasNextLine()) {
			linia = sc.nextLine();
			partes = linia.split(";");
			if (partes[0].equals(ciudadColidante)) {
				coordinadas = partes[2].split(",");
				sc.close();
				return coordinadas;
			}
		}
		sc.close();
		return null;
	}
}

