import java.util.HashMap;
import java.util.Map;

public class Marcadores {

    private Map<Enfermedad, Integer> marcadorEnfermedad;
    private Map<Color, Integer> marcadorColor;

    public Marcadores() {
        this.marcadorEnfermedad = new HashMap<>();
        this.marcadorColor = new HashMap<>();
        for (Enfermedad enfermedad : Enfermedad.values()) {
            marcadorEnfermedad.put(enfermedad, 0);
        }
        for (Color color : Color.values()) {
            marcadorColor.put(color, 0);
        }
    }

    public Map<Enfermedad, Integer> getMarcadorEnfermedad() {
        return marcadorEnfermedad;
    }

    public Map<Color, Integer> getMarcadorColor() {
        return marcadorColor;
    }

    public void incrementarMarcadorEnfermedad(Enfermedad enfermedad, int cantidad) {
        int valorActual = marcadorEnfermedad.get(enfermedad);
        marcadorEnfermedad.put(enfermedad, valorActual + cantidad);
    }

    public void decrementarMarcadorEnfermedad(Enfermedad enfermedad, int cantidad) {
        int valorActual = marcadorEnfermedad.get(enfermedad);
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
}
