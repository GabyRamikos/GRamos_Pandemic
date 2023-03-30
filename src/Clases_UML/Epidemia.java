import java.util.HashSet;
import java.util.Set;

public class Epidemia {

    private String nombre;
    private int turnoEfecto;
    private int incremento;
    private Set<Ciudad> ciudades;

    public Epidemia(String nombre, int turnoEfecto, int incremento) {
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
}
