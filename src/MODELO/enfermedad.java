package MODELO;

public class Enfermedad {
    private String nombre;
    private String[] sintomas;
    private int gravedad;
    private boolean curada;

    public Enfermedad(String nombre, String[] sintomas, int gravedad) {
        this.nombre = nombre;
        this.sintomas = sintomas;
        this.gravedad = gravedad;
        this.curada = false;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String[] getSintomas() {
        return this.sintomas;
    }

    public int getGravedad() {
        return this.gravedad;
    }

    public boolean siEstaCurada() {
        return this.curada;
    }

    public void curar() {
        this.curada = true;
 }
}
