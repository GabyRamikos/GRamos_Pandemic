package Clases_UML;

import java.util.List;
import java.util.ArrayList;

public class Jugador {
    
    private String nombre;
    private String rol;
    private List<Accion> mano;
    private Ciudad ciudadActual;
    
    public Jugador(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
        this.mano = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getRol() {
        return rol;
    }
    
    public List<Accion> getMano() {
        return mano;
    }
    
    public Ciudad getCiudadActual() {
        return ciudadActual;
    }
    
    public void moverACiudad(Ciudad ciudad) {
        ciudadActual = ciudad;
    }
    
    public void agregarAccion(Accion accion) {
        mano.add(accion);
    }
    
    public void quitarAccion(Accion accion) {
        mano.remove(accion);
    }
}