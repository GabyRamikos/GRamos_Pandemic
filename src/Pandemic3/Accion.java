package Pandemic3;

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

	public boolean mover(Ciudad nuevaCiudad) {
		if (ciudad.tieneConexion(nuevaCiudad)) { // Verificacion de si la nueva ciudad a la que se quiere mover el jugador es una ciudad válida													
			ciudad = nuevaCiudad; // Actualizacion de la ciudad actual del jugador con la nueva ciudad
			return true;
		}
		return false;
	}

	public boolean tratarEnfermedad(Enfermedad enfermedad) {
		Ciudad ciudad = getCiudad();
		if (ciudad.getNivelEnfermedad(enfermedad) > 0) {
			ciudad.disminuirNivelEnfermedad(enfermedad);
			return true;
		}
		return false;
	}

	public boolean construirCentroInvestigacion(Ciudad ciudad) {
		if (!ciudad.tieneCentroInvestigacion()) { // Verificacion de si no hay un centro de investigación construido en la ciudad
			if (ciudad.construirCentroInvestigacion()) { // Llamada al método construirCentroInvestigacion de la clase Ciudad															
				ciudad.restarPuntoAccion(); // Si la construcción es exitosa, se resta un punto de acción
				return true;
			}
		}
		return false;
	}

	public boolean encontrarCura(Enfermedad enfermedad) {
		// Posible agregación de la lógica para encontrar la cura de la enfermedad
		// Debería devolver verdadero si se encuentra la cura y falso en caso contrario
		return false;
	}

	public String getDescripcion() {
		switch (tipo) {
		case "mover":
			return "Mover a una ciudad cercana";
		case "tratarEnfermedad":
			return "Tratar la enfermedad en la ciudad actual";
		case "construirCentroInvestigacion":
			return "Construir un centro de investigación en la ciudad actual";
		case "encontrarCura":
			return "Buscar la cura para la enfermedad en la ciudad actual";
		default:
			return null;
		}
	}
}