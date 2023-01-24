package gestion;

import java.io.IOException;
import java.util.List;

import entrada.Teclado;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Fecha;
import modelo.Fichaje;
import modelo.Tiempo;

public class GestorFichajes {

	public static String texto() {
		return "0. Salir del programa. \n" + "1. Insertar un departamento en la base de datos\n"
				+ "2. Eliminar un departamento, por codigo, de la base de datos.\n"
				+ "3. Actualizar un empleado, por nombre, de la base de datos.";
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
					insertar();
					break;
				case 2:
					eliminarDepartamento();
					break;
				case 3:
					actualizar();
					break;

				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 3.");
				}
			} catch (RuntimeException e1) {
				System.out.println(e1.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (opcion != 0);
	}

	public static void insertar() {
		String denominacion = Teclado.leerCadena("Dime la denominacion del departamento");
		Double presupuesto = Teclado.leerReal("Dime el presupuesto para el departamento");
		Departamento departamento = new Departamento(denominacion, presupuesto);
		Boolean insertado = AccesoFichajes.insertar(departamento);
		if (insertado) {
			System.out.println("Se ha insertado un departamento en la base de datos.");
		} else {
			System.out.println("Se ha encontrado un departamento con esa denominacion en la base de datos.");
		}

	}

	private static void eliminarDepartamento() {
		int codigo = Teclado.leerEntero("Dime el codigo del departamento");
		Departamento departamento = AccesoFichajes.consultarCodigo(codigo);
		if (departamento != null) {
			List departamentos = AccesoFichajes.consultarEmpleado(codigo);

			if (departamentos.size() != 0) {
				System.out.println("Se han encontrado " + departamentos.size()
						+ " empleados relacionados con ese departamento en la base de datos:");
				System.out.println(departamentos);
			} else {
				AccesoFichajes.eliminar(codigo);
				System.out.println("Se ha eliminado un departamento de la base de datos.");
			}
		} else {
			System.out.println("No existe ningún departamento con ese codigo en la base de datos");
		}

	}

	private static void actualizar() {
		String nombre = Teclado.leerCadena("Dime el nombre del empleado");
		String denominacion = Teclado.leerCadena("Dime la denominacion del departamento al que insertar el empleado");
		Departamento dep = new Departamento(denominacion);

		if (AccesoFichajes.actualizar(nombre, dep)) {
			System.out.println("Se ha actualizado un empleado en la base de datos.");
		} else {
			System.out.println("No existe ningún empleado con ese nombre en la base de datos.");
		}

	}
}
