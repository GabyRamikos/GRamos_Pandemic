package MODELO;

import java.util.Map;
import java.util.HashMap;

public class Ciudad {
    
    private String nombre;
    private int poblacion;
    private Tablero coordenadas;
    private Map<Enfermedad, Integer> enfermedades;
    
    public Ciudad(String nombre, int poblacion, Tablero coordenadas) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.coordenadas = coordenadas;
        this.enfermedades = new HashMap<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getPoblacion() {
        return poblacion;
    }
    
    public Tablero getCoordenadas() {
        return coordenadas;
    }
    
    public Map<Enfermedad, Integer> getEnfermedades() {
        return enfermedades;
    }
    
    public void incrementarEnfermedad(Enfermedad enfermedad) {
        enfermedades.merge(enfermedad, 1, Integer::sum);
    }
    
    public void decrementarEnfermedad(Enfermedad enfermedad) {
        enfermedades.computeIfPresent(enfermedad, (key, value) -> value > 0 ? value - 1 : 0);
    }
}