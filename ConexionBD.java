package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ConexionBD {

	// Constantes que definen las credenciales de acceso a la base de datos
	private static final String USER = "DAW_PNDC22_23_ORGARA";
	private static final String PWD = "GOR123";
	// Dirección de la base de datos a la que se quiere conectar
	private static final String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";

	/**
	 * Método principal que se encarga de establecer una conexión con la base de
	 * datos y realizar una operación de inserción o de consulta, dependiendo de la
	 * opción elegida por el usuario.
	 */
	public static void main(String[] args) throws SQLException {

		Connection con = conectarBaseDatos();
		

		// Se intenta establecer una conexión con la base de datos
//		Connection con = conectarBaseDatos();
		System.out.println(con);

	}

	/**
	 * Método que se encarga de establecer una conexión con la base de datos Oracle.
	 * 
	 * @return Objeto Connection que representa la conexión establecida. Si la
	 *         conexión no se ha establecido, devuelve null.
	 */
	private static Connection conectarBaseDatos() {
		Connection con = null;
		System.out.println("Intentando conectarse a la base de datos");

		try {
			// Se carga el driver de Oracle
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Se establece la conexión con la base de datos
			con = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("Conectados a la base de datos");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver " + e);
		} catch (SQLException e) {
			System.out.println("Error en las credenciales o en la URL " + e);
		}

		return con;
	}

	/**
	 * Método que se encarga de insertar una puntuación en la tabla "PUNTUACIONES"
	 * de la base de datos.
	 * 
	 * @param con     Objeto Connection que representa la conexión establecida con
	 *                la base de datos.
	 * @param scanner Objeto Scanner que se utiliza para leer datos de entrada del
	 *                usuario.
	 */
	private static void insertarPuntuacion(Connection con, Scanner scanner) {
		System.out.println("Introduce tu nombre de usuario");
		String nombreUsuario = scanner.nextLine();
		System.out.println("Introduce tu puntuación");
		int puntuacion = scanner.nextInt();
		scanner.nextLine(); // Consume el salto de línea pendiente

		String sql = "INSERT INTO PUNTUACIONES (NOMBRE_USUARIO, ID_PUNTUACION) VALUES ('" + nombreUsuario + "', "
				+ puntuacion + ")";

		try {
			Statement st = con.createStatement();
			st.execute(sql);

			System.out.println("Puntuación registrada correctamente.");

		} catch (SQLException e) {
			System.out.println("Ha habido un error en el insert: " + e.getMessage());
		}
	}

	private static void mostrarRanking(Connection con) {
		String sql = "SELECT * FROM PUNTUACIONES ORDER BY ID_PUNTUACION DESC";
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("NOMBRE_USUARIO");
		columnNames.add("ID_PUNTUACION");
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Vector<String> row = new Vector<String>();
				row.add(rs.getString("NOMBRE_USUARIO"));
				row.add(Integer.toString(rs.getInt("ID_PUNTUACION")));
				data.add(row);
			}

			JTable table = new JTable(data, columnNames);
			JScrollPane scrollPane = new JScrollPane(table);
			JPanel panel = new JPanel();
			panel.add(scrollPane);

			JFrame frame = new JFrame("Tabla de Puntuaciones");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(panel);
			frame.pack();
			frame.setVisible(true);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
