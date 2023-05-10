package Pandemic3;

import java.util.List;

public class Epidemia {
    private Mapa mapa;
    private List<Enfermedad> enfermedades;
    private int brotes;
    private int enfermedadesActivas;

    public Epidemia(Mapa mapa, List<Enfermedad> enfermedades, int brotes) {
        this.mapa = mapa;
        this.enfermedades = enfermedades;
        this.brotes = brotes;
    }
    
    public int getBrotes() {
        return brotes;
    }
    
    public void aumentarBrotes(int cantidad) {
        brotes += cantidad;
    }

    public void propagarEnfermedades() {
        for (Enfermedad enfermedad : enfermedades) {
            List<Ciudad> ciudadesConEnfermedad = mapa.getCiudadesConEnfermedad(enfermedad);
            for (Ciudad ciudad : ciudadesConEnfermedad) {
                int nivelPropagacion = calcularNivelPropagacion(ciudad, enfermedad);
                propagarEnfermedad(ciudad, enfermedad, nivelPropagacion);
            }
        }
    }

    private int calcularNivelPropagacion(Ciudad ciudad, Enfermedad enfermedad) {
        int nivelPropagacion = ciudad.getNivelEnfermedad(enfermedad);
        for (Ciudad ciudadColindante : mapa.getCiudadesColindantes(ciudad)) {
            int nivelEnfermedadColindante = ciudadColindante.getNivelEnfermedad(enfermedad);
            nivelPropagacion += nivelEnfermedadColindante;
        }
        return nivelPropagacion;
    }

    private void propagarEnfermedad(Ciudad ciudad, Enfermedad enfermedad, int nivelPropagacion) {
        if (nivelPropagacion > 0) {
            List<Ciudad> ciudadesColindantes = mapa.getCiudadesColindantes(ciudad);
            int nivelPropagacionColindante = nivelPropagacion / ciudadesColindantes.size();
            for (Ciudad ciudadColindante : ciudadesColindantes) {
                ciudadColindante.aumentarNivelEnfermedad(enfermedad, nivelPropagacionColindante);
            }
        }
    }

    public void reducirNivelesEnfermedades() {
        for (int i = 0; i < mapa.getCiudades().length; i++) {
            for (int j = 0; j < mapa.getCiudades()[i].length; j++) {
                Ciudad ciudad = mapa.getCiudades()[i][j];
                for (Enfermedad enfermedad : enfermedades) {
                    int nivelEnfermedad = ciudad.getNivelEnfermedad(enfermedad);
                    if (nivelEnfermedad > 0) {
                        ciudad.disminuirNivelEnfermedad(enfermedad);
                    }
                }
            }
        }
    }
    
    // Método que incrementa el número de ciudades infectadas por ronda en 4 + brotes por derrota
    public void epidemia() {
        int numCiudadesInfectadas = 0;
        brotes += mapa.incrementarBrotesPorCiudadesEnNivel(3);
        for (Ciudad ciudad : mapa.getCiudades2()) {
            for (Enfermedad enfermedad : enfermedades) {
                int nivelEnfermedad = ciudad.getNivelEnfermedad(enfermedad);
                if (nivelEnfermedad > 0 && !ciudad.isInfectada()) {
                    ciudad.infectar();
                    numCiudadesInfectadas++;
                    enfermedad.incrementarVecesActivada(); // incrementa el contador de veces que se ha activado la enfermedad
                }
                if (nivelEnfermedad >= 3) {
                    int brotes = (int) Math.floor(nivelEnfermedad / 3);
                    for (int i = 0; i < brotes; i++) {
                        Ciudad ciudadAleatoria = mapa.getCiudadAleatoria();
                        if (ciudadAleatoria != null && !ciudadAleatoria.isInfectada()) {
                            ciudadAleatoria.infectar();
                            numCiudadesInfectadas++;
                            enfermedad.incrementarVecesActivada(); // incrementa el contador de veces que se ha activado la enfermedad
                        }
                    }
                }
            }
        }
        int brotesPorDerrota = 0;
        if (numCiudadesInfectadas > 0) {
            brotesPorDerrota = (int) Math.ceil(numCiudadesInfectadas / 4.0);
        }
        for (Enfermedad enfermedad : enfermedades) {
            if (enfermedad.getVecesActivada() >= 30) { // si se ha activado la enfermedad 30 veces o más, se pierde la partida
                perder();
                return;
            }
        }
        aumentarBrotes(brotesPorDerrota);
        if (brotes >= 8) { // Si alcanza el límite de brotes por derrota pierdes la partida
            perder();
            return;
        }
    }
    
    // Método de la derrota por superación de enfermedades/brotes máximas
    private void perder() {
        System.out.println("Has perdido la partida.");
        for (Ciudad ciudad : mapa.getCiudades2()) {
            ciudad.resetNivelesEnfermedades();
            ciudad.setInfectada(false);
        }
        brotes = 0;
        enfermedadesActivas = 0;
    }
    
    // Reinicia los niveles de todas las enfermedades en x ciudad
    public void resetNivelesEnfermedades() {
        for (Ciudad[] fila : mapa.getCiudades()) {
            for (Ciudad ciudad : fila) {
                ciudad.resetNivelesEnfermedades();
            }
        }
        enfermedadesActivas = 0;
    }
}