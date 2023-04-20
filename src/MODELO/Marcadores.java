package MODELO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Marcadores {

    private Map<enfermedad, Integer> marcadorEnfermedad;
    private Map<Color, Integer> marcadorColor;
    private int propagacion;
    
    public enum Color {
        ROJO,
        AZUL,
        AMARILLO,
        NEGRO
    }
    
    public enum enfermedad {
        ALFA,AZUL,
        BETA,ROJO,
        GAMA, VERDE,
        DELTA, AMARILLO
    }

    public Marcadores() {
    	this.marcadorEnfermedad = new HashMap<>();
        this.marcadorColor = new HashMap<>();
        this.propagacion = 0;

        // Leer datos del archivo CCP.bin
        try (DataInputStream dis = new DataInputStream(new FileInputStream("CCP.bin"))) {
            // Leer el color de cada enfermedad y agregarlo al mapa
            for (enfermedad enfermedad : enfermedad.values()) {
                int codigo = dis.readInt();
                String nombre = dis.readUTF();
                String colorStr = dis.readUTF();
                Color color = Color.valueOf(colorStr);
                marcadorEnfermedad.put(enfermedad, 0);
                marcadorColor.put(color, 0);
            }

            // Saltar las coordenadas x y
            dis.skipBytes(8);

        } catch (IOException e) {
            // Manejar la excepción apropiadamente
            e.printStackTrace();
        }

        // Incrementar los marcadores a cero
        for (enfermedad enfermedad : enfermedad.values()) {
            marcadorEnfermedad.put(enfermedad, 0);
        }
        for (Color color : Color.values()) {
            marcadorColor.put(color, 0);
        }
    }

    public Map<enfermedad, Integer> getMarcadorEnfermedad() {
        return marcadorEnfermedad;
    }

    public Map<Color, Integer> getMarcadorColor() {
        return marcadorColor;
    }

    public int getPropagacion() {
        return propagacion;
    }

    public void setPropagacion(int propagacion) {
        this.propagacion = propagacion;
    }

    public void incrementarMarcadorEnfermedad(enfermedad enfermedad, int cantidad) {
        int valorActual = marcadorEnfermedad.getOrDefault(enfermedad, 0);
        marcadorEnfermedad.put(enfermedad, valorActual + cantidad);
    }

    public void decrementarMarcadorEnfermedad(enfermedad enfermedad, int cantidad) {
        int valorActual = marcadorEnfermedad.getOrDefault(enfermedad, 0);
        marcadorEnfermedad.put(enfermedad, valorActual - cantidad);
    }

    public void incrementarMarcadorColor(Color color, int cantidad) {
        int valorActual = marcadorColor.get(color);
        marcadorColor.put(color, valorActual + cantidad);
    }

    public void decrementarMarcadorColor(Color color, int cantidad) {
        int valorActual = marcadorColor.get(color);
        marcadorColor.put(color, valorActual - cantidad);
    }

    public static void main(String[] args) {
        Marcadores marcadores = new Marcadores();

        // Incrementar el marcador de enfermedad de color amarillo en 2
        marcadores.incrementarMarcadorEnfermedad(enfermedad.AMARILLO, 2);
        System.out.println("Marcador enfermedad Delta de color amarillo: " + marcadores.getMarcadorEnfermedad().get(enfermedad.AMARILLO));

        // Incrementar el marcador de cura de color amarillo en 1
        marcadores.incrementarMarcadorColor(Color.AMARILLO, 1);
        System.out.println("Marcador de cura de color amarillo: " + marcadores.getMarcadorColor().get(Color.AMARILLO));

        // Establecer la escala de propagación en 4
        marcadores.setPropagacion(4);
        System.out.println("Escala de propagación: " + marcadores.getPropagacion());
    }
}
