package Ejercicio2;
import java.io.IOException;
import java.util.List;

import entrada.Teclado;
import modelo.Equipo;
import modelo.Fecha;

public class Main {


	/**
	 * Metodo con el menu que queremos imprimir
	 * @return Devuelve una string con el texto a imprimir
	 */
	public static String texto() {
		return 	  "0. Salir del programa. \n"
				+ "1. Insertar un equipo en la base de datos\n"
				+ "2. Consultar todos los equipos de la base de datos.\n"
				+ "3. Consultar un equipo, por nombre, de la base de datos\n"
				+ "4. Actualizar un equipo, por nombre, de la base de datos.\n"
				+ "5. Eliminar un equipo, por nombre, de la base de datos.\n"
				;
	}


	/**
	 * Desde este main se ejecutara el switch con las distintas opciones que contempla el menu
	 */
	public static void main(String[] args) {

		int opcion;
		do {
			System.out.println(texto());
			opcion=Teclado.leerEntero("Dime una opcion \n");
			try {
				switch (opcion) {
				case 0:
					System.out.println("Fin del programa");
					break;
				case 1: 
					insertar();
					break;
				case 2:
					consultar();
					break;
				case 3:
					consultarCodigo();
					break;
				case 4:
					actualizar();
					break;
				case 5:
					eliminarClase();
					break;
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 6.");
				}
			} catch (RuntimeException e1) {
				System.out.println(e1.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while(opcion!=0);
	}

	public static void insertar(){
		String nombre=Teclado.leerCadena("Dime el nombre del equipo");
		String ciudad=Teclado.leerCadena("Dime la ciudad del equipo");
		Equipo equipo = new Equipo(nombre,ciudad);
		Boolean insertado = AccesoBaseDatos.insertar(equipo);
		if(insertado) {
			System.out.println("Se ha insertado un equipo en la base de datos.");
		}else {
			System.out.println("Se ha encontrado un equipo con ese nombre en la base de datos.");
		}
		
		
	}

	
	private static void consultar() {
		List<Equipo> equipos = AccesoBaseDatos.consultar();
		if (equipos.size() == 0) {
			System.out.println("No se ha encontrado ningún equipo en la base de datos.");
		}
		else {
			for (Equipo equipo: equipos) {
				System.out.println(equipo.toString());
			}
			System.out.println("Se han consultado " + equipos.size() + 
			                   " equipos de la base de datos.");
		}
	}
	
	private static void consultarCodigo() {
		String nombre = Teclado.leerCadena("Dime el nombre del equipo");
		Equipo equipo = AccesoBaseDatos.consultarCodigo(nombre);
		if (equipo==null) {
			System.out.println("No existe ningún equipo con ese nombre en la base de datos.\n");
		}
		else {
			System.out.println(equipo);
		}
		
	}

	private static void actualizar() {
		String nombre=Teclado.leerCadena("Dime el nombre del equipo");
		String ciudad=Teclado.leerCadena("Dime la ciudad del equipo");
		
		if(AccesoBaseDatos.actualizar(nombre,ciudad)) {
			System.out.println("Se ha insertado un equipo en la base de datos.");
		}else {
			System.out.println("No existe ningún equipo con ese nombre en la base de datos.");
		}
		
		
		
	}
	
	private static void eliminarClase() {
		String nombre = Teclado.leerCadena("Dime el nombre del equipo");
		Equipo equipo = AccesoBaseDatos.consultarCodigo(nombre);
		if(equipo!=null) {
			List equipos =AccesoBaseDatos.consultarEquipo(nombre);
		

			if(equipos.size()!=0) {
				System.out.println("Se han encontrado " + equipos.size() + " jugadores relacionados con ese equipo en la base de datos:");
				System.out.println(equipos);
			}else {
				List partidos =AccesoBaseDatos.consultarPartido(nombre);
				if(partidos.size()!=0) {
					System.out.println("Se han encontrado"+partidos.size()+"partidos relacionados con ese equipo en la base de datos:");
					System.out.println(partidos);
				}else{
				AccesoBaseDatos.eliminar(nombre);
				System.out.println("Se ha eliminado un equipo de la base de datos.");
				}
			}
		}else {
			System.out.println("No existe ningún equipo con ese código en la base de datos.");
		}
		
	}




}
