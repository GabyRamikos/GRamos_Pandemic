package Pandemic3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Pandemic3.Accion;
import Pandemic3.Ciudad;
import Pandemic3.Enfermedad;
import Pandemic3.Epidemia;
import Pandemic3.Jugador;
import Pandemic3.Mapa;
import Pandemic3.Marcadores;

public class Juego2 {

    private List<Jugador> jugador;
    private Mapa mapa;
    private Marcadores marcadores;
    private int indiceJugadorActual;
    private Ciudad ciudadActual;
    private boolean finJuego;

    public Juego2() {
        jugador = new ArrayList<>();
        mapa = new Mapa();
        marcadores = new Marcadores();
        indiceJugadorActual = 0;
        ciudadActual = null;
        finJuego = false;
    }

    public void agregarJugador(Jugador player) {
        jugador.add(player);
    }

    public void addCity(Ciudad city) {
        mapa.addCity(city);
    }

    public void addDisease(Enfermedad disease) {
        marcadores.addDisease(disease);
    }

    public Jugador getCurrentPlayer() {
        return jugador.get(indiceJugadorActual);
    }

    public Ciudad getCurrentCity() {
        return ciudadActual;
    }

    public boolean isGameOver() {
        return finJuego;
    }

    public void startGame() {
        for (Jugador jugador : jugador) {
            player.setLocation(mapa.getCities().get(0));
        }
        indiceJugadorActual = 0;
        ciudadActual = mapa.getCities().get(0);
        finJuego = false;
    }

    public void nextTurn() {
        indiceJugadorActual = (indiceJugadorActual + 1) % jugador.size();
        ciudadActual = null;
    }

    public void movePlayer(Ciudad city) {
        ciudadActual = city;
    }

    public void treatDisease() {
        ciudadActual.decreaseDiseaseLevel();
    }

    public void buildResearchCenter() {
        ciudadActual.setResearchCenter(true);
    }

    public void passTurn() {
        nextTurn();
    }

    public void checkForEpidemic() {
        if (Math.random() < 0.01) {
            for (City city : mapa.getCities()) {
                city.increaseDiseaseLevel();
            }
        }
    }

    public void checkForWin() {
        for (Enfermedad disease : marcadores.getDiseases()) {
            if (disease.isCured()) {
                continue;
            }
            for (City city : mapa.getCities()) {
                if (city.getDiseaseLevel() > 0) {
                    return;
                }
            }
            disease.setCured(true);
        }
        finJuego = true;
    }
}