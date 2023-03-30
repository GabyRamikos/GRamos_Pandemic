package MODELO;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Juego {

	private List<Jugador> jugadores;
	private List<Ciudad> ciudades;
	private Mapa mapa;

	// Constructor del Juego()
	public Juego() {
		jugadores = new ArrayList<Jugador>();
		ciudades = new ArrayList<Ciudad>();
		mapa = new Mapa();
	}

	// Constructor del agregarJugador()
	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador); // Agrega al jugador del juego
	}

	// Constructor del quitarJugador()
	public void quitarJugador(Jugador jugador) {
		jugadores.remove(jugador); // Elimina al jugador del juego
	}

	// Constructor del empezarJuego()
	public void empezarJuego() {
		// Comprueba si hay suficientes jugadores para empezar el juego
		if (jugadores.size() < 1) {
			System.out.println("Se necesitan al menos 1 jugador para empezar el juego.");
			return;
		}

		// Configura el mapa y distribuye las ciudades entre los jugadores
		mapa.configurar(ciudades);
		for (Jugador jugador : jugadores) {
			jugador.setCiudades(mapa.distribuirCiudades(jugador, ciudades));
		}

		// Inicia el turno del primer jugador
		Jugador jugadorActual = jugadores.get(0);
		jugadorActual.iniciarTurno();
	}
	
	// Constructor del método terminarJuego()
	public void terminarJuego() {
		// Comprueba si algún jugador ha ganado
		for (Jugador jugador : jugadores) {
			if (jugador.haGanado()) {
				System.out.println("¡" + jugador.getNombre() + " ha ganado el juego!");
				return;
			}
		}

		// Si ningún jugador ha ganado, sigue jugando
		Jugador jugadorActual = obtenerJugadorActual();
		jugadorActual.terminarTurno();
		jugadorActual = obtenerSiguienteJugador();
		jugadorActual.iniciarTurno();
	}

	// Constructor del getJugadores()
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	// Constructor del getCiudades()
	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	// Constructor del getMapa()
	public Mapa getMapa() {
		return mapa;
	}
}