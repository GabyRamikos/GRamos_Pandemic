package Pandemic3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.Random;

public class Jugador {
    
    private String nombre;
    private int puntosAccion;
    private int puntosCuracion;
    private int ubicacion;
    private int ubicacionX;
    private int ubicacionY;
    private int accionesRestantes;
    private ArrayList<Accion> accionesPendientes;
    private Enfermedad enfermedadActual;
    
    // Constructor
    public Jugador(String nombre, int ubicacionX, int ubicacionY) {
        this.nombre = nombre;
        this.puntosAccion = 4;
        this.puntosCuracion = 3;
        this.ubicacionX = ubicacionX;
        this.ubicacionY = ubicacionY;
        this.accionesRestantes = 3; // O el número que desees
        this.accionesPendientes = new ArrayList<Accion>();
    }
    
    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getUbicacion() {
        return ubicacion;
    }
    
    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public int getUbicacionX() {
        return ubicacionX;
    }
    
    public void setUbicacionX(int ubicacionX) {
        this.ubicacionX = ubicacionX;
    }
    
    public int getUbicacionY() {
        return ubicacionY;
    }
    
    public void setUbicacionY(int ubicacionY) {
        this.ubicacionY = ubicacionY;
    }
    
    public int getPuntosAccion() {
        return puntosAccion;
    }

    public int getPuntosCuracion() {
        return puntosCuracion;
    }

    public void restarPuntoAccion() {
        puntosAccion--;
    }

    public void restarPuntoCuracion() {
        puntosCuracion--;
    }

    public void aumentarPuntoAccion() {
        puntosAccion++;
    }

    public void aumentarPuntoCuracion() {
        puntosCuracion++;
    }
    
    public void setEnfermedadActual(Enfermedad enfermedad) {
        this.enfermedadActual = enfermedad;
    }

    public Enfermedad getEnfermedadActual() {
        return enfermedadActual;
    }
    
    public void intentarCurarEnfermedad(Jugador jugador) {
//        Ciudad ciudadActual = this.getCiudadActual();
        Ciudad ciudadActual = Mapa.getCiudadEn(this.ubicacion % Mapa.getCiudades().length, this.ubicacion / Mapa.getCiudades().length);
        if (ciudadActual.tieneCentroInvestigacion() && enfermedadActual.avanzarCura() < 4) {
            enfermedadActual.avanzarCura();
            System.out.println("¡Has avanzado en la cura de la enfermedad " + enfermedadActual.getNombreEnfermedad() + "!");
        } else if (!ciudadActual.tieneCentroInvestigacion()) {
            System.out.println("No hay un centro de investigación en esta ciudad.");
        } else if (enfermedadActual.avanzarCura() >= 4) {
            System.out.println("La enfermedad " + enfermedadActual.getNombreEnfermedad() + " ya está curada.");
        }
    }
    
    //** Método que recibe el listado de las acciones pendientes por realizar
    public int getAccionesRestantes() {
        return accionesRestantes;
    }
    
    //** Método que recibe el listado de las acciones pendientes por realizar
    public void setAccionesRestantes(int accionesRestantes) {
        this.accionesRestantes = accionesRestantes;
    }
    
    //** Método que recibe el listado de las acciones pendientes por realizar
    public ArrayList<Accion> getAccionesPendientes() {
        return accionesPendientes;
    }
    
    //** Método que da el listado de las acciones pendientes por realizar
    public void setAccionesPendientes(ArrayList<Accion> accionesPendientes) {
        this.accionesPendientes = accionesPendientes;
    }
    
    // Método para disminuir el número de acciones restantes del jugador
    public void usarAccion() {
        this.accionesRestantes--;
    }
    
    // Método para agregar una acción pendiente al jugador
    public void agregarAccionPendiente(Accion accion) {
        this.accionesPendientes.add(accion);
    }
    
    // Método para eliminar una acción pendiente del jugador
    public void eliminarAccionPendiente(Accion accion) {
        this.accionesPendientes.remove(accion);
    }
    
    // Método para comprobar si se ha agotado todas las acciones
    public boolean accionesAgotadas() {
        return this.accionesRestantes == 0;
    }
    
    
    
    // Método para comprobar si ha encontrado la cura para todas las enfermedades
    public boolean haGanado(Mapa mapa) {
        for (Enfermedad enfermedad : mapa.getEnfermedades()) {
            if (!enfermedad.estaCurada()) {
                return false;
            }
        }
        return true;
    }
    
    // Método para comprobar si no ha podido encontrar la cura para todas las enfermedades
    public boolean haPerdido(Mapa mapa) {
    	Ciudad ciudadActual = mapa.getCiudadEn(this.ubicacionX, this.ubicacionY);
        Enfermedad enfermedad = ciudadActual.getEnfermedadActiva();
        if (enfermedad != null && this.puntosCuracion == 0) {
            List<Ciudad> ciudadesConEnfermedad = mapa.getCiudadesConEnfermedad(enfermedad);
            return ciudadesConEnfermedad.contains(ciudadActual);
        }
        return false;
    }
    
    // Método para mover al jugador a una nueva ubicación
    public void mover(int nuevaUbicacion) {
        this.ubicacion = nuevaUbicacion;
    }
    
    // Método para escoger las ciudades aleatorias 
    public static Ciudad elegirCiudadAleatoria() {
        List<Ciudad> ciudades = Ciudad.leerCiudades();
        Random random = new Random();
        return ciudades.get(random.nextInt(ciudades.size()));
    }

    public static Enfermedad elegirEnfermedadAleatoria() throws IOException {
        List<Enfermedad> enfermedades = Enfermedad.leerEnfermedades();
        Random random = new Random();
        return enfermedades.get(random.nextInt(enfermedades.size()));
    }
    
    // Método para imprimir las ciudades a las que puede moverse el jugador desde su ubicación actual
    public void imprimirCiudadesDisponibles(Mapa mapa) {
        Ciudad ciudadActual = mapa.getCiudadEn(this.ubicacion % mapa.getCiudades().length, this.ubicacion / mapa.getCiudades().length);
        Set<Ciudad> ciudadesVecinas = mapa.getConexiones().get(ciudadActual);
        System.out.println("Ciudades disponibles:");
        for (Ciudad ciudad : ciudadesVecinas) {
            System.out.println("- " + ciudad.getNombre());
        }
    }
    

    public boolean realizarAccionPendiente() throws IOException {
        if (accionesPendientes.size() > 0) { // Verificamos si hay acciones pendientes
            Accion accion = accionesPendientes.get(0); // Obtenemos la primera acción de la lista de acciones pendientes
            switch (accion.getTipo()) {
                case "mover":
                    // Llamamos al método mover de la clase Accion pasándole la nueva ciudad como parámetro
                    Ciudad nuevaCiudad = elegirCiudadAleatoria();
                    return accion.mover(nuevaCiudad);
                case "tratarEnfermedad":
                    // Llamamos al método tratarEnfermedad de la clase Accion pasándole la enfermedad como parámetro
                    Enfermedad enfermedad = elegirEnfermedadAleatoria();
                    return accion.tratarEnfermedad(enfermedad);
                case "construirCentroInvestigacion":
                    // Llamamos al método construirCentroInvestigacion de la clase Accion pasándole la ciudad actual como parámetro
                    Ciudad ciudadActual = accion.getCiudad();
                    return accion.construirCentroInvestigacion(ciudadActual);
                case "encontrarCura":
                    // Llamamos al método encontrarCura de la clase Accion pasándole la enfermedad como parámetro
                    Enfermedad enfermedadACurar = elegirEnfermedadAleatoria();
                    return accion.encontrarCura(enfermedadACurar);
                default:
                    return false;
            }
        }
        return false;
    }    
    
 // Método para mover al jugador a una nueva ciudad
    public boolean moverTotal(int nuevaUbicacionTotal, Mapa mapa) {
		if (this.accionesAgotadas()) {
			return false;
		}
    	//Mapa mapa = Mapa.getInstance();
        Ciudad ciudadActual = mapa.getCiudadEn(this.ubicacion % mapa.getCiudades().length, this.ubicacion / mapa.getCiudades().length);
        Ciudad nuevaCiudad = mapa.getCiudadEn(nuevaUbicacionTotal % mapa.getCiudades().length, nuevaUbicacionTotal / mapa.getCiudades().length);
        if (!ciudadActual.tieneConexion(nuevaCiudad)) {
            return false;
        }
        this.ubicacion = nuevaUbicacionTotal;
        this.usarAccion();
        return true;
        
    }
    
    // Creacion de subclases para las diferentes acciones
    public class AccionTratar extends Accion {
		private Enfermedad enfermedad;
		public AccionTratar(Ciudad ciudad, Enfermedad enfermedad) {
			super("Tratar Enfermedad", ciudad);
			this.enfermedad = enfermedad;
		}
		public Enfermedad getEnfermedad() {
			return enfermedad;
		}
		public boolean realizar() {
			Ciudad ciudad = this.getCiudad();
			if (ciudad.getNivelEnfermedad(enfermedad) > 0) {
				ciudad.disminuirNivelEnfermedad(enfermedad);
				ciudad.restarPuntoAccion();
				return true;
			}
			return false;
		}
    }
    
    public class AccionConstruirCentroInvestigacion extends Accion {
		private Enfermedad enfermedad;
		public AccionConstruirCentroInvestigacion(Ciudad ciudad) {
			super("Construir Centro de Investigación", ciudad);
		}
		public boolean realizar() {
			Ciudad ciudad = this.getCiudad();
			if (ciudad.getNivelEnfermedad(enfermedad) > 0) {
				ciudad.disminuirNivelEnfermedad(enfermedad);
				ciudad.restarPuntoAccion();
				return true;
			}
			return false;
		}
    }
    
    public class AccionEncontrarCura extends Accion {
        private Enfermedad enfermedad;
        public AccionEncontrarCura(Ciudad ciudad, Enfermedad enfermedad) {
            super("Encontrar la cura de " + enfermedad.getNombreEnfermedad(),ciudad);
            this.enfermedad = enfermedad;
            jugador.setEnfermedadActual(enfermedad);
        }
        public boolean realizar() {
            // Implementación para encontrar cura
            return false;
        }
    }
    
    // Método para imprimir información sobre el jugador
    public void imprimirInfo() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Ubicación: " + this.ubicacion);
        System.out.println("Acciones restantes: " + this.accionesRestantes);
        System.out.println("Acciones pendientes: ");
        for (Accion accion : this.accionesPendientes) {
            System.out.println("- " + accion.getDescripcion());
        }
    }
}
