package MODELO;

import java.util.List;
import java.util.ArrayList;

public class Jugador {
    
    private String nombre;
    private String rol;
    private List<Accion> mano;
    private Ciudad ciudadActual;
    
	// Constructor del Jugador()
    public Jugador(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
        this.mano = new ArrayList<>();
    }
    
	// Constructor del getNombre()
    public String getNombre() {
        return nombre;
    }
    
	// Constructor del getRol()
    public String getRol() {
        return rol;
    }
    
	// Constructor del getMano()
    public List<Accion> getMano() {
        return mano;
    }
    
	// Constructor del getCiudadActual()
    public Ciudad getCiudadActual() {
        return ciudadActual;
    }
    
	// Constructor del moverACiudad()
    public void moverACiudad(Ciudad ciudad) {
        ciudadActual = ciudad;
    }
    
	// Constructor del agregarAccion()
    public void agregarAccion(Accion accion) {
        mano.add(accion);
    }
    
	// Constructor del quitarAccion()
    public void quitarAccion(Accion accion) {
        mano.remove(accion);
    }
}