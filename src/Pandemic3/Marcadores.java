package Pandemic3;

import java.awt.Color;

import Pandemic2.Epidemia.DiseaseColor;

public class Marcadores {
    private int[] enfermedadColor;
    private int numCentrosInvestigacion;
    private int numEpidemias;

    public Marcadores() {
        enfermedadColor = new int[4]; // Hay 4 colores de enfermedad
        numCentrosInvestigacion = 0;
        numEpidemias = 0;
    }
    
    //? Agregar método para el valor actual de cada barra de enfermedad de color

    // Método para la aumentación de la barra de progreso para cada enfermedad de color
    public void aumentarBarraEnfermedadColor(DiseaseColor colorInfeccion, int cantidad) {
        enfermedadColor[colorInfeccion.ordinal()] += cantidad;
    }

    // Método para la disminución de la barra de progreso para cada enfermedad de color
    public void disminuirBarraEnfermedadColor(DiseaseColor colorInfeccion, int cantidad) {
        enfermedadColor[colorInfeccion.ordinal()] -= cantidad;
    }

    // Método que obtiene del progreso de la barra de cada enfermedad
    public int getBarraEnfermedadColor(DiseaseColor colorInfeccion) {
        return enfermedadColor[colorInfeccion.ordinal()];
    }

    // Método del contador para los centros construidos
    public void construirCentroInvestigacion() {
        numCentrosInvestigacion++;
    }

    // Método que recibe del número de centros ya construidos
    public int getNumCentrosInvestigacion() {
        return numCentrosInvestigacion;
    }

    // Método para la incrementación de la barra de brotes
    public void aumentarNumEpidemias() {
        numEpidemias++;
    }

    // Método que recibe del número de brotes producidos
    public int getNumEpidemias() {
        return numEpidemias;
    }
}

