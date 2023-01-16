import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import entrada.Teclado;

public class GestorCine {

	public static String texto() {
		return "0. Salir del programa. \n" + "1. Insertar salas desde una coleccion con sentencia preparada.\n"
				+ "2. Eliminar una prestacion mediante una transaccion por código\n"
				+ "3. Consultar todas las peliculas.\n";
	}

	public static void main(String[] args) {
		try {
			int opcion;
			do {
				System.out.println(texto());
				opcion = Teclado.leerEntero("Dime una opcion \n");
				switch (opcion) {
				case 0:
					System.out.println("Fin del programa");
					break;
				case 1:

					System.out
							.println("Se han insertado " + AccesoDatos.insertarSalas() + " salas en la base de datos.");
					break;

				case 2:
					eliminar();
					break;

				case 3:
					consultarTodos();
					break;

				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 4.");
				}
			} while (opcion != 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e1) {
			System.out.println(e1.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void eliminar() throws IOException, ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Dime el codigo de la prestacion");
		Prestacion prestacion = AccesoDatos.comprobar(codigo);
		if (prestacion != null) {
			int[] num = AccesoDatos.eliminar(codigo);
			System.out.println(num);
			System.out.println("Se ha eliminado la prestacion");
		} else {
			System.out.println("No existe ninguna prestacion con ese código en la base de datos.");
		}
	}

	public static void consultarTodos() throws ClassNotFoundException, SQLException {
		ArrayList<Pelicula> peliculas = AccesoDatos.consultarTodasPeliculas();
		if (peliculas.size() == 0) {
			System.out.println("No se ha encontrado ninguna pelicula en la base de datos.");
		} else {
			for (Pelicula peli : peliculas) {
				System.out.println(peli);
			}
			System.out.println("Se han consultado " + peliculas.size() + " peliculas de la base de datos");
		}

	}

}
