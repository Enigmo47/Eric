import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entrada.Teclado;

public class AccesoDepartamento {
	// Consulta todos los departamentos de la base de datos personal.db
	static Teclado tec = new Teclado();

	public static void CrearDepartamento() {

		Connection conexion = null;
		try {
			String nombre = Teclado.leerCadena("¿Nombre? ");
			String ubicacion = Teclado.leerCadena("¿Ubicación? ");
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:db\\personal.db");
			System.out.println("Conectado");
			String sentenciaInsertar = "INSERT INTO departamento (nombre, ubicacion)" + "VALUES ('" + nombre + "', '"
					+ ubicacion + "')";
			Statement sentencia = conexion.createStatement();
			int filasInsertadas = sentencia.executeUpdate(sentenciaInsertar);
			if (filasInsertadas == 0) {
				System.out.println("Ya existe un departamento con ese código en la base de datos.");
			} else {
				System.out.println("Se ha insertado un departamento en la base de datos.");
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error al cargar el conector de SQLite: " + cnfe.getMessage());
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("Error de SQL: " + sqle.getMessage());
			sqle.printStackTrace();
		} finally {
			try {
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException sqle) {
				System.out.println("Error al cerrar la base de datos: " + sqle.getMessage());
				sqle.printStackTrace();
			}
		}
	}

	public static void ConsultarDepartamento() {
		Connection conexion = null;

		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:db\\personal.db");
			System.out.println("Conectado");
			int contadorDepartamentos = 0;
			String sentenciaConsultar = "SELECT * FROM departamento";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);
			while (resultados.next()) {
				System.out.println("Código = " + resultados.getInt("codigo") + ", Nombre = "
						+ resultados.getString("nombre") + ", Ubicación = " + resultados.getString("ubicacion"));
				contadorDepartamentos++;
			}
			if (contadorDepartamentos == 0) {
				System.out.println("No se ha encontrado ningún departamento en la base de datos.");
			} else {
				System.out
						.println("Se han consultado " + contadorDepartamentos + " departamentos de la base de datos.");
			}
			resultados.close();
			sentencia.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error al cargar el conector de SQLite: " + cnfe.getMessage());
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("Error de SQL: " + sqle.getMessage());
			sqle.printStackTrace();
		} finally {
			try {
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException sqle) {
				System.out.println("Error al cerrar la base de datos: " + sqle.getMessage());
				sqle.printStackTrace();
			}
		}

	}

	public static void ConsultarDepartamentoC() {
		Connection conexion = null;

		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:db\\personal.db");
			System.out.println("Conectado");
			int contadorDepartamentos = 0;
			String sentenciaConsultar = "SELECT * FROM departamento WHEN codigo LIKE 'codigo'";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);
			int codigo = tec.leerEntero("Introduzca codigo");

			while (resultados.next()) {
				if (resultados.getInt("codigo") == codigo) {
					System.out.println("Código = " + resultados.getInt("codigo") + ", Nombre = "
							+ resultados.getString("nombre") + ", Ubicación = " + resultados.getString("ubicacion"));
					contadorDepartamentos++;
				}
			}
			if (contadorDepartamentos == 0) {
				System.out.println("No se ha encontrado ningún departamento en la base de datos.");
			} else {
				System.out
						.println("Se han consultado " + contadorDepartamentos + " departamentos de la base de datos.");
			}
			resultados.close();
			sentencia.close();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error al cargar el conector de SQLite: " + cnfe.getMessage());
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("Error de SQL: " + sqle.getMessage());
			sqle.printStackTrace();
		} finally {
			try {
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException sqle) {
				System.out.println("Error al cerrar la base de datos: " + sqle.getMessage());
				sqle.printStackTrace();
			}
		}

	}

}
