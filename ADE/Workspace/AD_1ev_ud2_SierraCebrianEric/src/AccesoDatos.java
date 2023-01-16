import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.sqlite.SQLiteConfig;

public class AccesoDatos {

	static Connection conexion = null;

	public static int insertarSalas() throws SQLException, ClassNotFoundException, IOException {
		Class.forName("org.sqlite.JDBC");
		int contador = 0;
		try {

			BufferedReader entrada = null;
			ArrayList<Sala> sala = new ArrayList<Sala>();
			File archivo = new File("data\\salas.txt");
			archivo.createNewFile(); // si ya existe no hace nada
			entrada = new BufferedReader(new FileReader(archivo));
			String linea = entrada.readLine();

			while (linea != null) {
				String aux[];
				aux = linea.split(";");
				Sala s = new Sala(aux[0], Integer.parseInt(aux[1]), Double.parseDouble(aux[2]),
						Double.parseDouble(aux[3]));
				sala.add(s);
				linea = entrada.readLine();
			}
			entrada.close();

			conexion = DriverManager.getConnection("jdbc:sqlite:db\\salas_de_cine.db");

			try {
				conexion.setAutoCommit(false);
				String sentenciaInsertar = "INSERT INTO sala(nombre, numero_butacas, precio_normal, precio_reducido) VALUES (?, ?, ?, ?)";
				PreparedStatement sentencia = conexion.prepareStatement(sentenciaInsertar);
				for (Sala s : sala) {
					sentencia.setString(1, s.getNombre());
					sentencia.setInt(2, s.getNumeroButacas());
					sentencia.setDouble(3, s.getPrecioNormal());
					sentencia.setDouble(4, s.getPrecioReducido());
					contador += sentencia.executeUpdate();
				}
				conexion.commit();
			} catch (SQLException sqle) {
				if (conexion != null) {
					conexion.rollback();
				}
				throw sqle;
			}
		} finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return contador;
	}

	public static Prestacion comprobar(int codigo) throws IOException, ClassNotFoundException, SQLException {
		ArrayList<Prestacion> prestacion = consultarTodasPrestaciones();
		for (Prestacion p : prestacion) {
			if (p.getCodigo() == codigo) {
				return p;
			}
		}
		return null;
	}

	public static int[] eliminar(int codigo) throws IOException, ClassNotFoundException, SQLException {

		int filasEliminadas = 0;
		int[] nums = { 2 };
		conexion = DriverManager.getConnection("jdbc:sqlite:db\\salas_de_cine.db");
		try {
			conexion.setAutoCommit(false);

			String sentenciaEliminar = "delete from prestacion where codigo_prestacionsala=" + codigo;
			Statement sentencia = conexion.createStatement();
			nums[1] = sentencia.executeUpdate(sentenciaEliminar);
			String sentenciaEliminarPrestacion = "delete from prestacion where codigo=" + codigo;
			Statement sentencia1 = conexion.createStatement();
			nums[2] = sentencia1.executeUpdate(sentenciaEliminarPrestacion);

			conexion.commit();
		} catch (SQLException sqle) {
			if (conexion != null) {
				conexion.rollback();
			}
			throw sqle;
		} finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return nums;
	}

	public static ArrayList<Pelicula> consultarTodasPeliculas() throws ClassNotFoundException, SQLException {
		ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:db\\salas_de_cine.db");
			String sentenciaConsultar = "SELECT * FROM pelicula";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);
			while (resultados.next()) {
				Pelicula pelicula = new Pelicula(resultados.getInt("codigo"), resultados.getString("titulo"),
						resultados.getString("sinopsis"), resultados.getInt("duracion"),
						resultados.getString("fecha_estreno"), null);// Sé que debería sacar la sala pero no he
																		// conseguido hacerlo
				listaPeliculas.add(pelicula);
			}
			resultados.close();
			sentencia.close();
		} finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return listaPeliculas;
	}

	public static ArrayList<Prestacion> consultarTodasPrestaciones() throws ClassNotFoundException, SQLException {
		ArrayList<Prestacion> listaPrestaciones = new ArrayList<Prestacion>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:db\\salas_de_cine.db");
			String sentenciaConsultar = "SELECT * FROM prestacion";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);
			while (resultados.next()) {
				Prestacion prestacion = new Prestacion(resultados.getInt("codigo"),
						resultados.getString("descripcion"));
				listaPrestaciones.add(prestacion);
			}
			resultados.close();
			sentencia.close();
		} finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return listaPrestaciones;
	}

}
