package MODELO;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Pandemic.enfermedades;

public class enfermedad {
    public static enfermedad AMARILLO;
	private Map<Integer, enfermedades> enfermedadesMap;
    private int mapaX;
    private int mapaY;

    public enfermedad() {
        enfermedadesMap = new HashMap<>();
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("CCP.bin"));
            for (int i = 0; i < 4; i++) {
                int codigo = dis.readInt();
                String nombre = dis.readUTF();
                String color = dis.readUTF();
                enfermedadesMap.put(codigo, new enfermedades(nombre, color));
            }
            mapaX = dis.readInt();
            mapaY = dis.readInt();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMapaX() {
        return mapaX;
    }

    public int getMapaY() {
        return mapaY;
    }

    public enfermedades getEnfermedad(int codigo) {
        return enfermedadesMap.get(codigo);
    }
}
