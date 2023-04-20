package MODELO;

import java.util.List;
import java.util.Scanner;

import javax.management.relation.Role;

import Pandemic.Menu_Pandemic;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private Role rol;
	private List<Accion> mano;
	private Ciudad ciudadActual;
    private Accion accion;


	// Constructor del Jugador()
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.rol = rol;
		this.ciudadActual = ciudadActual;
        this.accion = accion;
		this.mano = new ArrayList<>();
	}

	// Constructor del getNombre()
	public String getNombre() {
		return nombre;
	}

	// Constructor del getRol()
	public String getRol() {
		return rol;
	}

	// Constructor del getMano()
	public List<Accion> getMano() {
		return mano;
	}

	// Constructor del getCiudadActual()
	public Ciudad getCiudadActual() {
		return ciudadActual;
	}

	public Accion getAccion() {
        return accion;
    }
	
	// Constructor del moverACiudad()
	public void moverACiudad(Ciudad ciudad) {
		ciudadActual = ciudad;
	}

	// Constructor del agregarAccion()
	public void agregarAccion(Accion accion) {
		mano.add(accion);
	}

	// Constructor del quitarAccion()
	public void quitarAccion(Accion accion) {
		mano.remove(accion);
	}

	public static void main(String[] args) {

		// Creamos un objeto jugador y lo inicializamos con un nombre
		Jugador jugador1 = new Jugador("Jugador 1");

		// Creamos un objeto ciudad y lo inicializamos con un nombre
		Ciudad ciudad1 = new Ciudad("Ciudad 1");

		// Movemos al jugador a la ciudad creada anteriormente
		jugador1.moverACiudad(ciudad1);
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Selecciona tu rol: (1) Contingencia Epidemiológica, (2) Médico, (3) Científico, (4) Especialista en Operaciones");
		int seleccion = scanner.nextInt();

		Rol rolSeleccionado;
		switch (seleccion) {
		    case 1:
		        rolSeleccionado = Rol.CONTINGENCIA_EPIDEMIOLOGICA;
		        break;
		    case 2:
		        rolSeleccionado = Rol.MEDICO;
		        break;
		    case 3:
		        rolSeleccionado = Rol.CIENTIFICO;
		        break;
		    case 4:
		        rolSeleccionado = Rol.ESPECIALISTA_OPERACIONES;
		        break;
		    default:
		        System.out.println("Selección inválida, seleccionando rol por defecto.");
		        rolSeleccionado = Rol.CONTINGENCIA_EPIDEMIOLOGICA;
		        break;
		}

		Jugador jugador = new Jugador("Jugador 1", rolSeleccionado, Ciudad.get(0), moverEntreCiudades);


		// Creamos un objeto de tipo Accion y lo agregamos a la mano del jugador
		// Acciones del jugador creados
		Accion moverEntreCiudades = new Accion("Mover entre ciudades", Ciudad.get(0));
		Accion vueloDirecto = new Accion("Vuelo directo", Ciudad.get(1));
		Accion vueloCharter = new Accion("Vuelo chárter", Ciudad.get(2));
		Accion puenteAereo = new Accion("Puente aéreo", Ciudad.get(3));
		Accion tratarInfeccion = new Accion("Tratar infección", Ciudad.get(0));
		Accion construirCentroInvestigacion = new Accion("Construir centro de investigación", Ciudad.get(0));
		Accion encontrarCura = new Accion("Encontrar cura", Ciudad.get(4));

		jugador1.agregarAccion(accion1);

		// Quitamos la Accion anterior de la mano del jugador
		jugador1.quitarAccion(accion1);
	}
}