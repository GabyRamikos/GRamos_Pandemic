package Pandemic;

import java.util.Scanner;

public class Silco2 {
    private String ciudad;
    private String letras;
    private int[] numeros;
    private String[] ciudades;

    // Constructor
    public Silco2(String entrada) {
        String[] partes = entrada.split(";");
        this.ciudad = partes[0];
        this.letras = partes[1];
        String[] nums = partes[2].split(",");
        this.numeros = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            this.numeros[i] = Integer.parseInt(nums[i]);
        }
        this.ciudades = partes[3].split(",");
    }

    // Getters y setters
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public String[] getCiudades() {
        return ciudades;
    }

    public void setCiudades(String[] ciudades) {
        this.ciudades = ciudades;
    }

    // Función para mostrar los resultados
    public void mostrarResultados() {
        String todasCiudades = String.join(", ", ciudades);
        System.out.printf("Silco actúa en %s con los números %s, %d y %d, y cuyas ciudades colindantes son %s%n",
                ciudad, letras, numeros[0], numeros[1], todasCiudades);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la frase entera:");
        String entrada = sc.nextLine();
        Silco2 silco = new Silco2(entrada);
        silco.mostrarResultados();
    }
}

