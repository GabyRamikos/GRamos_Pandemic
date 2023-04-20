package MODELO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class main_juego {
    private List<Jugador> jugadores;
    private List<Ciudad> ciudades;
    private Mapa mapa;
    
    public main_juego() {
        jugadores = new ArrayList<>();
        ciudades = new ArrayList<>();
        mapa = new Mapa(0, 0);
    }
    
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }
    
    public void quitarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }
    
    public void empezarJuego() {
        // Lógica para iniciar el juego
    }
    
    public void terminarJuego() {
        // Lógica para terminar el juego
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
    
    public static void main(String[] args) {
        main_juego juego = new main_juego();
        
        Jugador jugador = new Jugador("Gaby");
        
        juego.agregarJugador(jugador);
        
        juego.empezarJuego();
        // Lógica para jugar
        
        juego.terminarJuego();
    }
}
