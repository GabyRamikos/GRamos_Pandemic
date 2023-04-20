package MODELO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Mapa {
    private int coordenadaX;
    private int coordenadaY;

    public Mapa(int x, int y) {
        coordenadaX = x;
        coordenadaY = y;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadas(int x, int y) {
        coordenadaX = x;
        coordenadaY = y;
    }

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("CCP.bin");
        DataInputStream dis = new DataInputStream(fis);

        String descripcion = dis.readUTF();

        for (int i = 0; i < 4; i++) {
            int codigoEnfermedad = dis.readInt();
            String nombreEnfermedad = dis.readUTF();
            String colorEnfermedad = dis.readUTF();
        }

        int x = dis.readInt();
        int y = dis.readInt();
        Mapa mapa = new Mapa(x, y);

        System.out.println("Coordenadas iniciales del mapa: (" + mapa.getCoordenadaX() + ", " + mapa.getCoordenadaY() + ")");

        //mapa.setCoordenadas(20, 30); -- Aquí se actualizaría las coordenadas del mapa si es necesario en un futuro
        //System.out.println("Coordenadas actualizadas del mapa: (" + mapa.getCoordenadaX() + ", " + mapa.getCoordenadaY() + ")");
        
        dis.close();
    }
}