package CONTROLADOR;

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
}