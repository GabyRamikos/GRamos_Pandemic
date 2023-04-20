package MODELO;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import Pandemic.Menu_Pandemic;

public class Juego {

	private List<Jugador> jugadores;
	private List<Ciudad> ciudades;
	private Mapa mapa;
	private int tamMapa;
	private HashMap<Integer, Enfermedad> enfermedades;

	// Constructor del Juego()
	public Juego(String archivoCiudades, String archivoCiudadesRedactadas) throws IOException {
		this.ciudades = Ciudad.leerCiudades(archivoCiudades, archivoCiudadesRedactadas);
		this.jugadores = new ArrayList<>();
	}

	public enfermedad getEnfermedad(int codigo) {
		return MODELO.Marcadores.enfermedad.get(codigo);
	}

	public int getTamMapa() {
		return tamMapa;
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

		// Agrega una instancia de IA como jugador
		IA ia = new IA();
		jugadores.add(ia);

		// Configura el mapa y distribuye las ciudades entre los jugadores
		mapa = new Mapa(ciudades);
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

		// Si el jugador actual es la IA, tomar una decisión
		if (jugadorActual instanceof IA) {
			IA ia = (IA) jugadorActual;
			ia.tomarDecision(mapa);
		} else {
			// Si el jugador actual no es la IA, inicia el turno del siguiente jugador
			int indiceJugadorActual = jugadores.indexOf(jugadorActual);
			Jugador siguienteJugador = jugadores.get((indiceJugadorActual + 1) % jugadores.size());
			siguienteJugador.iniciarTurno();
		}
	}

	// Constructor del obtenerJugadorActual()
	public Jugador obtenerJugadorActual() {

	// Encuentra al jugador que tiene el turno actual
	public Jugador obtenerJugadorActual() {
		for (Jugador jugador : jugadores) {
			if (jugador.tieneTurno()) {
				return jugador;
			}
		}
		return null;
	}

	// Constructor del método cargarEnfermedades()
	public void cargarEnfermedades(String archivoEnfermedades) throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(new File(archivoEnfermedades));
		ObjectInputStream in = new ObjectInputStream(file);

		Pandemic.enfermedades = (HashMap<Integer, Enfermedad>) in.readObject();

		in.close();
		file.close();
	}

	// Constructor del método main()
	public static void main(String[] args) {
		try {
			Juego juego = new Juego("ciudades.txt", "ciudades_redactadas.txt");
			juego.cargarEnfermedades("enfermedades.dat");

			// Agrega jugadores al juego
			Jugador jugador1 = new Jugador("Jugador 1", Color.BLUE);			

			juego.agregarJugador(jugador1);

			// Inicia el juego
			juego.empezarJuego();

			// Muestra el menú del juego
			Menu_Pandemic.mostrar(juego);

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al cargar los datos del juego.");
			e.printStackTrace();
		}
	}
}