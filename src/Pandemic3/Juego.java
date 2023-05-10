package Pandemic3;

import java.util.Scanner;

public class Juego {
	private Mapa mapa;
	private Jugador jugador;
	private int numJugadores;
	private int nivelDificultad;
	private String nombre;

	public Juego() {
		this.mapa = new Mapa();
		this.jugador = new Jugador(nombre, nivelDificultad, numJugadores);
		this.numJugadores = 1; // valor por defecto per a un jugador
		this.nivelDificultad = 1; // valor por defecto
	}

	public void iniciarPartida() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido a Pandemic!");
		System.out.println("----------------------");
		System.out.println("1. Iniciar nueva partida");
		System.out.println("2. Mostrar instrucciones");
		System.out.println("3. Mostrar versión");
		System.out.println("4. Salir");
		System.out.print("Seleccione una opción: ");
		int opcion = scanner.nextInt();
		while (opcion < 1 || opcion > 4) {
			System.out.print("Opción inválida. Seleccione una opción: ");
			opcion = scanner.nextInt();
		}
		switch (opcion) {
		case 1:
			System.out.print("Ingrese el nivel de dificultad (1-3): ");
			this.nivelDificultad = scanner.nextInt();
			while (this.nivelDificultad < 1 || this.nivelDificultad > 3) {
				System.out.print("Nivel de dificultad inválido. Ingrese el nivel de dificultad (1-3): ");
				this.nivelDificultad = scanner.nextInt();
			}
//			this.mapa.inicializarMapa(this.nivelDificultad);
//			this.jugador.inicializarJugadores(this.numJugadores);
			this.jugar();
			break;
		case 2:
			this.mostrarInstrucciones();
			break;
		case 3:
			this.mostrarVersion();
			break;
		case 4:
			System.out.println("Hasta luego!");
			break;
		}
	}

	public void mostrarInstrucciones() {
		System.out.println("Instrucciones del juego...");
	}

	public void mostrarVersion() {
		System.out.println("Versión 1.0");
	}

	public void jugar() {
		Scanner scanner = new Scanner(System.in);
		while (!this.jugador.haPerdido(mapa) && !this.jugador.haGanado(mapa)) {
			System.out.println("Turno del jugador " + this.jugador.getTurnoActual());
			System.out.println("---------------------------------");
			System.out.println("1. Moverse");
			System.out.println("2. Tratar enfermedad");
			System.out.println("3. Curar enfermedad");
			System.out.println("4. Construir centro de investigación");
			System.out.println("5. Pasar turno");
			System.out.print("Seleccione una opción: ");
			int opcion = scanner.nextInt();
			while (opcion < 1 || opcion > 5) {
				System.out.print("Opción inválida. Seleccione una opción: ");
				opcion = scanner.nextInt();
			}
			switch (opcion) {
			case 1:
				moverse(scanner);
				break;
			case 2:
				tratarEnfermedad(scanner);
				break;
			case 3:
				curarEnfermedad(scanner);
				break;
			case 4:
				construirCentroInvestigacion(scanner);
				break;
			case 5:
				pasarTurno();
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}
		}
		if (this.jugador.haPerdido(mapa)) {
			System.out.println("Lo siento, has perdido.");
		} else if (this.jugador.haGanado(mapa)) {
			System.out.println("Felicidades, han ganado la partida!");
		}
	}

	private void moverse(Scanner scanner) {
		System.out.println("Escriba el nombre de la ciudad a la que desea moverse: ");
		String ciudadDestino = scanner.nextLine();
		while (!this.mapa.ciudadValida(ciudadDestino)) {
			System.out.println("Ciudad inválida. Escriba el nombre de una ciudad válida: ");
			ciudadDestino = scanner.nextLine();
		}
		this.jugador.moverse(ciudadDestino, this.mapa);
	}

	private void tratarEnfermedad(Scanner scanner) {
		System.out.println("Escriba el nombre de la ciudad donde desea tratar la enfermedad: ");
		String ciudad = scanner.nextLine();
		while (!this.mapa.ciudadValida(ciudad)) {
			System.out.println("Ciudad inválida. Escriba el nombre de una ciudad válida: ");
			ciudad = scanner.nextLine();
		}
		this.jugador.tratarEnfermedad(ciudad, this.mapa);
	}

	private void curarEnfermedad(Scanner scanner) {
		System.out.println("Escriba el nombre de la enfermedad que desea curar: ");
		String enfermedad = scanner.nextLine();
		while (!this.mapa.enfermedadValida(enfermedad)) {
			System.out.println("Enfermedad inválida. Escriba el nombre de una enfermedad válida: ");
			enfermedad = scanner.nextLine();
		}
		this.jugador.curarEnfermedad(enfermedad, this.mapa);
	}

	private void construirCentroInvestigacion(Scanner scanner) {
		System.out.println("Escriba el nombre de la ciudad donde desea construir el centro de investigación: ");
		String ciudad = scanner.nextLine();
		while (!this.mapa.ciudadValida(ciudad)) {
			System.out.println("Ciudad inválida. Escriba el nombre de una ciudad válida: ");
			ciudad = scanner.nextLine();
		}
		this.jugador.construirCentroInvestigacion(ciudad, this.mapa);
	}

	private void pasarTurno() {
		this.jugador.pasarTurno();
		this.mapa.pasarTurno();
	}
}
