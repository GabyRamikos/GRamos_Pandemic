package CONTROLADOR;

public class Accion {
    private String tipo;
    private Ciudad ciudad;

    public Accion(String tipo, Ciudad ciudad) {
        this.tipo = tipo;
        this.ciudad = ciudad;
    }

    public String getTipo() {
        return tipo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}