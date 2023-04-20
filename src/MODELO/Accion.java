package MODELO;

import java.util.*;

public class Accion {
    private String tipo;
    private Ciudad ciudad;

    public Accion(String tipo, Ciudad ciudad) {
        this.tipo = tipo;
        this.ciudad = ciudad;
    }

    public String getTipo() {
        return tipo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public static void main(String[] args) {
    	// Lectura ciudades desde el archivo ciudades.txt
        List<Ciudad> ciudades = Ciudad.leerCiudades();

        // lista de acciones creada
        List<Accion> acciones = new ArrayList<>();

        // Acciones del jugador
        Accion moverEntreCiudades = new Accion("Mover entre ciudades", ciudades.get(0));
        Accion vueloDirecto = new Accion("Vuelo directo", ciudades.get(1));
        Accion vueloCharter = new Accion("Vuelo chárter", ciudades.get(2));
        Accion puenteAereo = new Accion("Puente aéreo", ciudades.get(3));
        Accion tratarInfeccion = new Accion("Tratar infección", ciudades.get(0));
        Accion construirCentroInvestigacion = new Accion("Construir centro de investigación", ciudades.get(0));
        Accion encontrarCura = new Accion("Encontrar cura", ciudades.get(4));

        // Acciones del jugador a la lista
        acciones.add(moverEntreCiudades);
        acciones.add(vueloDirecto);
        acciones.add(vueloCharter);
        acciones.add(puenteAereo);
        acciones.add(tratarInfeccion);
        acciones.add(construirCentroInvestigacion);
        acciones.add(encontrarCura);

        // Mostrar las acciones
        for (Accion accion : acciones) {
            System.out.println("Tipo: " + accion.getTipo() + ", Ciudad: " + accion.getCiudad().getNombre());
        }
    }
}
