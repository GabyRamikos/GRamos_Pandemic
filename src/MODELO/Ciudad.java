package MODELO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ciudad {
    
    private String nombre;
    private int poblacion;
    private Mapa coordenadas;
    private Map<Pandemic.enfermedades, Integer> enfermedades;
    private List<String> ciudadesColindantes;
    
    public Ciudad(String nombre, int poblacion, Mapa coordenadas, List<String> ciudadesColindantes) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.coordenadas = coordenadas;
        this.enfermedades = new HashMap<>();
        this.ciudadesColindantes = ciudadesColindantes;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getPoblacion() {
        return poblacion;
    }
    
    public Mapa getCoordenadas() {
        return coordenadas;
    }
    
    public Map<Pandemic.enfermedades, Integer> getEnfermedades() {
        return enfermedades;
    }
    
    public void incrementarEnfermedad(Pandemic.enfermedades enfermedad) {
        enfermedades.merge(enfermedad, 1, Integer::sum);
    }
    
    public void decrementarEnfermedad(Pandemic.enfermedades enfermedad) {
        enfermedades.computeIfPresent(enfermedad, (key, value) -> value > 0 ? value - 1 : 0);
    }
    
    public List<String> getCiudadesColindantes() {
        return ciudadesColindantes;
    }
    
    // Método para leer las ciudades del archivo "ciudades.txt"
    public static List<Ciudad> leerCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("ciudades.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                String nombre = partes[0];
                int poblacion = Integer.parseInt(partes[1]);
                String[] coordenadasPartes = partes[2].split(",");
                Mapa coordenadas = new Mapa(Integer.parseInt(coordenadasPartes[0]), Integer.parseInt(coordenadasPartes[1]));
                String[] ciudadesColindantes = partes[3].split(",");
                List<String> ciudadesColindantesList = new ArrayList<>();
                for (String ciudad : ciudadesColindantes) {
                    ciudadesColindantesList.add(ciudad);
                }
                ciudades.add(new Ciudad(nombre, poblacion, coordenadas, ciudadesColindantesList));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ciudades;
    }
}
