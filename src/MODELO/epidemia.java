package MODELO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class epidemia {
    private String nombre; // nombre epidemia
    private int turnoEfecto; // escala propagación
    private int incremento; // incremento de la escala por turno
    private Set<Ciudad> ciudades; // ciudades infectadas

    public epidemia(String nombre, int turnoEfecto, int incremento) {
        this.nombre = nombre;
        this.turnoEfecto = turnoEfecto;
        this.incremento = incremento;
        this.ciudades = new HashSet<>();
    }

    public String getNombre() { 
        return nombre;
    }

    public int getTurnoEfecto() {
        return turnoEfecto;
    }

    public int getIncremento() {
        return incremento;
    }

    public Set<Ciudad> getCiudades() {
        return ciudades;
    }

    public void agregarCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }

    public void removerCiudad(Ciudad ciudad) {
        ciudades.remove(ciudad);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
    	
    	// Lectura ciudades desde el archivo ciudades.txt
        List<Ciudad> ciudades = Ciudad.leerCiudades();
        
        // Crea la epidemia
        epidemia pandemia = new epidemia("Alfa", 3, 2);

        // Agrega las ciudades infectadas
        pandemia.agregarCiudad(ciudades.get(0));
        pandemia.agregarCiudad(ciudades.get(1));
        
        // Muestra info de la epidemia
        System.out.println("Epidemia: " + pandemia.getNombre());
        System.out.println("Turno de efecto: " + pandemia.getTurnoEfecto());
        System.out.println("Incremento: " + pandemia.getIncremento());
        
        // Muestra ciudades infectadas
        for (Ciudad ciudad : pandemia.getCiudades()) {
            System.out.println("Ciudades infectadas: " + ciudad.getNombre());
        }
        pandemia.removerCiudad(ciudades.get(0)); // Quita la primera ciudad ejemplo
        
        // Muestra ciudades infectadas quitando la primera ciudad curada, ejemplo
        System.out.println("Ciudades infectadas sin curar:");
        for (Ciudad ciudad : pandemia.getCiudades()) {
            System.out.println(ciudad.getNombre());
        }
    }
}
