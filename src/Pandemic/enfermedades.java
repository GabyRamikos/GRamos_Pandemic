package Pandemic;

import java.io.*;

public class enfermedades {

    public static void main(String[] args) throws IOException {

        // Abre el archivo CCP.bin para leerlo
        FileInputStream fis = new FileInputStream("CCP.bin");
        DataInputStream dis = new DataInputStream(fis);

        // Lee la primera línea del archivo CCP.bin
        String descripcion = dis.readUTF();
        
        // Muestra la explicación del archivo CCP.bin en la consola
    	System.out.println(descripcion);

    	// Lee los datos de las 4 enfermedades y los muestra en la consola
    	for (int i = 0; i < 4; i++) {
    	int codigoEnfermedad = dis.readInt();
    	String nombreEnfermedad = dis.readUTF();
    	String colorEnfermedad = dis.readUTF();
    	System.out.println(codigoEnfermedad + ", " + nombreEnfermedad + ", " + colorEnfermedad);
    	}
    	
    	// Lee las coordenadas x y y del archivo CCP.bin
    	int x = dis.readInt();
    	int y = dis.readInt();

    	// Muestra las coordenadas x y y en la consola
    	System.out.println("Coordenadas x: " + x);
    	System.out.println("Coordenadas y: " + y);

    	// Cierra el archivo CCP.bin
    	dis.close();
        
        // Abre el archivo ciudades-enfermedad.bin para escribirlo
        FileOutputStream fos = new FileOutputStream("ciudades-enfermedad.bin");
        DataOutputStream dos = new DataOutputStream(fos);
        
        // Abre el archivo ciudades.txt para leer
        BufferedReader br = new BufferedReader(new FileReader("ciudades.txt"));

        // Lee cada línea del archivo ciudades.txt y mostrar la ciudad y su enfermedad correspondiente
        String linea;
        while ((linea = br.readLine()) != null) {
        	
        	// Separación de la entrada en sus componentes/partes
            String[] ciudad = linea.split(";");
            String nombreCiudad = ciudad[0];
            int codEnfermedad = Integer.parseInt(ciudad[1]);
            String[] coordenadas = ciudad[2].split(",");
            int coordenadaX1 = Integer.parseInt(coordenadas[0]);
            int coordenadaX2 = Integer.parseInt(coordenadas[1]);
            String codCiudad = "", codColor = "";
            
            // Selector para representar cada enfermedad mediante su código propio
            switch (codEnfermedad) {
                case 0:
                    codCiudad = "Alfa";
                    codColor = "Azul";
                    break;
                case 1:
                    codCiudad = "Beta";
                    codColor = "Rojo";
                    break;
                case 2:
                    codCiudad = "Gama";
                    codColor = "Verde";
                    break;
                case 3:
                    codCiudad = "Delta";
                    codColor = "Amarillo";
                    break;
                default:
                    break;
            }
            // Muestra la información de cada ciudad con su enfermedad correspondiente si se descomenta en la consola
            System.out.println("La ciudad " + nombreCiudad + " que está en las coordenadas ("+ coordenadaX1 + ", " + coordenadaX2 + ")" + " tiene la enfermedad" + ": " + codCiudad + " " + codColor);
            
            // Escribir la información de la ciudad en ciudades-enfermedad.bin
            dos.writeUTF(nombreCiudad);
            dos.writeInt(codEnfermedad);
            dos.writeInt(coordenadaX1);
            dos.writeInt(coordenadaX2);
        }

        // Cierre del archivo ciudades.txt
        br.close();

        // Cierre de los archivos
        dis.close();
        dos.close();
    }
}
