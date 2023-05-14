package Pandemic3;

import java.util.ArrayList;
import java.util.Scanner;

import Pandemic3.Jugador.AccionConstruirCentroInvestigacion;

public class Juegofail {
	private Jugador jugadorActual;
	private Ciudad ciudadActual;
	private int nivelesEnfermedad;
	private ArrayList<AccionConstruirCentroInvestigacion> centrosInvestigacion;
	private ArrayList<Ciudad> ciudades;

	public Juegofail() {
	        // Inicializa el juego
	        jugadorActual = null;
	        ciudadActual = null;
	        nivelesEnfermedad = 0;
	        centrosInvestigacion = new ArrayList<>();
	        ciudades = new ArrayList<>();
	    }

	public void agregarCiudad(Ciudad ciudad) {
		// Agrega una ciudad al juego
		ciudades.add(ciudad);
	}

	public void agregarCentroInvestigacion(AccionConstruirCentroInvestigacion centro) {
		// Agrega un centro de investigación al juego
		centrosInvestigacion.add(centro);
	}

	public void setJugadorActual(Jugador jugador) {
		// Cambia el jugador actual
		jugadorActual = jugador;
	}

	public void setCiudadActual(Ciudad ciudad) {
		// Cambia la ciudad actual
		ciudadActual = ciudad;
	}

	public void incrementarNivelesEnfermedad() {
		// Incrementa el nivel de enfermedad
		nivelesEnfermedad++;
	}

	public void decrementarNivelesEnfermedad() {
		// Decrementa el nivel de enfermedad
		nivelesEnfermedad--;
	}

	public Jugador getJugadorActual() {
		// Retorna el jugador actual
		return jugadorActual;
	}

	public Ciudad getCiudadActual() {
		// Retorna la ciudad actual
		return ciudadActual;
	}

	public int getNivelesEnfermedad() {
		// Retorna el nivel de enfermedad actual
		return nivelesEnfermedad;
	}


	public ArrayList<Ciudad> getCiudades() {
		// Retorna la lista de ciudades
		return ciudades;
	}

	public void jugar() {
	    // Se inicia el juego en la primera ciudad de la lista de ciudades
	    ciudadActual = ciudades.get(0);

	    while (nivelesEnfermedad < 4) { // Se juega hasta que se alcance el nivel máximo de enfermedad
	        // Se obtiene la lista de acciones disponibles para el jugador en la ciudad actual
	        ArrayList<Accion> accionesDisponibles = ciudadActual.getAccionesDisponibles(jugadorActual);

	        // Se le muestra al jugador las acciones disponibles y se le pide que seleccione una
	        mostrarAccionesDisponibles(accionesDisponibles);
	        Accion accionSeleccionada = seleccionarAccion(accionesDisponibles);

	        // Se ejecuta la acción seleccionada
	        accionSeleccionada.ejecutar(this);

	        // Se incrementa el nivel de enfermedad en una unidad
	        incrementarNivelesEnfermedad();

	        // Se cambia al siguiente jugador en la lista de jugadores
	        jugadorActual = jugadorActual.getSiguienteJugador();
	    }

	    // Se termina el juego
	    terminarJuego();
	}


}