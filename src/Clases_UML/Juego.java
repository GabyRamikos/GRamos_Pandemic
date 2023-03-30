package Clases_UML;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Juego { 
    
    private List<Jugador> jugadores;
    private List<Ciudad> ciudades;
    private Mapa mapa;
    
    public Juego() {
        jugadores = new ArrayList<Jugador>();
        ciudades = new ArrayList<Ciudad>();
        mapa = new Mapa();
    }
    
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }
    
    public void quitarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }
    
    public void empezarJuego() {
    // Comprobar si hay suficientes jugadores para empezar el juego
    if (jugadores.size() < 1) {
        System.out.println("Se necesitan al menos 1 jugador para empezar el juego.");
        return;
    }
    
    // Configurar el mapa y distribuir las ciudades entre los jugadores
    mapa.configurar(ciudades);
    for (Jugador jugador : jugadores) {
        jugador.setCiudades(mapa.distribuirCiudades(jugador, ciudades));
    }
    
    // Iniciar el turno del primer jugador
    Jugador jugadorActual = jugadores.get(0);
    jugadorActual.iniciarTurno();
}

public void terminarJuego() {
    // Comprobar si algún jugador ha ganado
    for (Jugador jugador : jugadores) {
        if (jugador.haGanado()) {
            System.out.println("¡" + jugador.getNombre() + " ha ganado el juego!");
            return;
        }
    }
    
    // Si ningún jugador ha ganado, seguir jugando
    Jugador jugadorActual = obtenerJugadorActual();
    jugadorActual.terminarTurno();
    jugadorActual = obtenerSiguienteJugador();
    jugadorActual.iniciarTurno();
}

    
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    
    public List<Ciudad> getCiudades() {
        return ciudades;
    }
    
    public Mapa getMapa() {
        return mapa;
    }
}