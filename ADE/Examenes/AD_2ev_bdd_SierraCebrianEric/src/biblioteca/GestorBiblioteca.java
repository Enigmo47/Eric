package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.XMLDBException;

import entrada.Teclado;

public class GestorBiblioteca {

	/**
	 * Metodo con el menu que queremos imprimir
	 * 
	 * @return Devuelve una string con el texto a imprimir
	 */
	public static String texto() {
		return "0. Salir del programa. \n" + "1. Consultar todos los libros ordenados por año (descendente).\n"
				+ "2. Insertar socio en XML.\n" + "3. Eliminar Socio.\n";
	}

	public static void main(String[] args) {

		int opcion;
		do {
			System.out.println(texto());
			opcion = Teclado.leerEntero("Dime una opcion \n");
			try {
				switch (opcion) {
				case 0:
					System.out.println("Fin del programa");
					break;
				case 1:
					consultar();
					break;
				case 2:
					insertar();
					break;
				case 3:
					eliminar();
					break;
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 3.");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XMLDBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (opcion != 0);
	}

	public static void insertar()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		String dni = Teclado.leerCadena("¿DNI? ");
		String nombre = Teclado.leerCadena("¿Nombre? ");
		String localidad = Teclado.leerCadena("¿Localidad? ");
		String telefono = Teclado.leerCadena("¿Telefono? ");
		String correo = Teclado.leerCadena("¿Correo? ");
		Socio socio = new Socio(dni, nombre, localidad, telefono, correo);
		AccesoBiblioteca.insertar(socio);
		System.out.println("Se ha insertado un socio en la base de datos.");

	}

	private static void consultar()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		ArrayList<Libro> libros = AccesoBiblioteca.consultarLibros();
		for (Libro libro : libros) {
			System.out.println(libro);
		}
		if (libros.size() == 0) {
			System.out.println("No se ha encontrado ningun libro en el XML.");
		} else {
			System.out.println("Se han consultado " + libros.size() + " libros de la base de datos.");
		}
	}

	private static void eliminar()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		String dni = Teclado.leerCadena("¿DNI?");
		Socio comSocio = AccesoBiblioteca.consultarSocio(dni);
		if (comSocio != null) {
			ArrayList<Prestamo> prestamos = AccesoBiblioteca.consultarPrestamos(dni);
			if (prestamos.size() > 0) {
				System.out.println("Se han encontrado " + prestamos.size() + " productos relacionados con ese socio"
						+ "en la base de datos:");
				for (Prestamo pres : prestamos) {
					System.out.println(pres);
				}
			} else {
				AccesoBiblioteca.eliminar(dni);
				System.out.println("Se ha eliminado un socio de la base de datos.");
			}
		} else {
			System.out.println("No se ha encontrado ningun socio en la base de datos.");
		}
	}
}
