import java.io.IOException;
import java.util.ArrayList;

import entrada.Teclado;

public class MainEmpleado {

	public static String texto() {
		return 	  "0. Salir del programa. \n"
				+ "1. Insertar un empleado en el fichero de texto.\n"
				+ "2. Consultar todos los empleados del fichero de texto.\n"
				+ "3. Consultar un empleado, por código, del fichero de texto.\n"
				+ "4. Actualizar un empleado, por código, del fichero de texto.\n"
				+ "5. Eliminar un empleado, por código, del fichero de texto";
	}


	public static void main(String[] args) {
		try {
			int opcion;
			do {
				System.out.println(texto());
				opcion=Teclado.leerEntero("Dime una opcion \n");
				switch (opcion) {
				case 0:
					System.out.println("Fin del programa");
					break;

				case 1: 
					insertar();
					break;

				case 2:
					listar();
					break;

				case 3:
					consultarID();
					break;
				case 4:
					actualizar();

					break;
				case 5:
					int codigo3 = Teclado.leerEntero("Dime el codigo del departamento");
					if(!AccesoEmpleado.comprobar(codigo3)) {
						AccesoEmpleado.eliminar(codigo3);
						System.out.println("Se ha eliminado un empleado del fichero de texto.");
					}else {
						System.out.println("No existe ningún empleado con ese código en el fichero de texto.");
					}


					break;
				default:
					System.out.println("La opción de menú debe estar comprendida entre 0 y 5.");
				}
			}while(opcion!=0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (RuntimeException e1) {
			System.out.println(e1.getMessage());
		}


	}


	private static void actualizar() throws IOException {
		ArrayList<Departamento> deps = AccesoDepartamento.ListarDepartamento();
		System.out.println("Existen los siguientes departamentos:");
		for(Departamento d: deps) {
			System.out.println(d);
		}

		int codigo2 = Teclado.leerEntero("Dime el codigo del empleado");

		if(!AccesoEmpleado.comprobar(codigo2)) {
			int codigo_departamento=Teclado.leerEntero("Dime el codigo del departamento del empleado");
			String nombre=Teclado.leerCadena("Dime el nombre del empleado");
			String fecha_alta=Teclado.leerCadena("Dime la fecha de alta del empleado");
			String fecha[]=fecha_alta.split("/");
			if(fecha.length <4 && (Integer.parseInt(fecha[2])<= 3000 && Integer.parseInt(fecha[2])>=0) &&
					(Integer.parseInt(fecha[1])<= 12 && Integer.parseInt(fecha[1])>=1) &&
					(Integer.parseInt(fecha[0])<= 31 && Integer.parseInt(fecha[0])>=1)) {
				Double salario=Teclado.leerReal("Dime el salario del empleado");
				Empleado emps = new Empleado(codigo2,codigo_departamento,nombre,fecha_alta,salario);
				AccesoEmpleado.actualizar(emps);
				System.out.println("Se ha actualizado un empleado del fichero de texto.");
			}


		}else {
			System.out.println("No existe ningún empleado con ese código en el fichero de texto.");
		}
	}


	private static void consultarID() throws IOException {
		int codigo1 = Teclado.leerEntero("Dime el codigo del empleado");
		if(!AccesoEmpleado.comprobar(codigo1)) {
			Empleado e = AccesoEmpleado.consultar(codigo1);
			System.out.println(e);
		}else {
			System.out.println("No existe ningún empleado con ese código en el fichero de texto. ");
		}
	}


	private static void listar() throws IOException {
		ArrayList<Empleado> emps1 =AccesoEmpleado.ListarEmpleado();
		if(emps1.size()!=0) {
			for(Empleado e: emps1) {
				System.out.println(e);
			}
		}else {
			System.out.println("El fichero de texto no tiene ningún empleado.");
		}
	}


	private static void insertar() throws IOException {
		String fecha[];
		int codigo=Teclado.leerEntero("Dime el codigo del empleado");
		if(AccesoEmpleado.comprobar(codigo)) {
			int codigo_departamento=Teclado.leerEntero("Dime el codigo del departamento del empleado");
			if(AccesoEmpleado.comprobarDepartamento(codigo_departamento)) {
				String nombre=Teclado.leerCadena("Dime el nombre del empleado");
				String fecha_alta=Teclado.leerCadena("Dime la fecha de alta del empleado");
				fecha=fecha_alta.split("/");
				if(fecha.length <4 && (Integer.parseInt(fecha[2])<= 3000 && Integer.parseInt(fecha[2])>=0) &&
						(Integer.parseInt(fecha[1])<= 12 && Integer.parseInt(fecha[1])>=1) &&
						(Integer.parseInt(fecha[0])<= 31 && Integer.parseInt(fecha[0])>=1)) {

					Double salario=Teclado.leerReal("Dime el salario del empleado");
					Empleado emps = new Empleado(codigo,codigo_departamento,nombre,fecha_alta,salario);
					AccesoEmpleado.insertar(emps);
					System.out.println("Se ha insertado un departamento en el fichero de texto.");

				}else{
					System.out.println("Fecha introducida no valida");
				}
			}else {
				System.out.println("No existe ningún departamento con ese código en el fichero de texto.");
			}
		}else {
			System.out.println("Ya existe otro departamento con ese código en el fichero de texto.");
		}
	}

}
