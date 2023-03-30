package Pandemic;

public class ciudad {
	
	// Clase creada para representar la ciudad
	public static class Ciudad {
		private String ciudad;
		private int[] coordenadas;
		private int[][] ciudadCoordenadas;
		
		
		// Constructor creado dentro de la clase
		public Ciudad(String ciudad, int[] coordenadas, int[][] ciudadCoordenadas) {
			this.ciudad = ciudad;
			this.coordenadas = coordenadas;
			this.ciudadCoordenadas = ciudadCoordenadas;
		}
		
		// Método getters y setters de las coordenadas para cada ciudad
		public void setCiudadCoordenadas(int[][] ciudadCoordenadas) {
			this.ciudadCoordenadas = ciudadCoordenadas;
		}
	}
}
