package personal;

import entrada.Teclado;

public class GestorPersonal {

	public static String texto() {
		return "0. Salir del programa. \n" + "1. Consultar todos los Empleados por salario ascendiente.\n"
				+ "2. Insertar un Empleado en la base de datos.\n" + "3. Eliminar un empleado.\n";
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
					AccesoPersonal.consultar();
					break;
				case 2:
					int codigo = Teclado.leerEntero("¿Código? ");
					String nombre = Teclado.leerCadena("¿Nombre? ");
					String fechaAlta = Teclado.leerCadena("¿Fecha de alta? ");
					String departamento = Teclado.leerCadena("¿Departamento? ");
					double salario = Teclado.leerReal("¿Salario?");

					Empleado emp = new Empleado(codigo, nombre, fechaAlta, departamento, salario);
					AccesoPersonal.insertar(emp);
					break;
				case 3:
					codigo = Teclado.leerEntero("¿Código? ");
					AccesoPersonal.borrar(codigo);
					break;
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
				}
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (opcion != 0);
	}

}
