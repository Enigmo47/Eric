package Ejercicio1;
import java.util.List;

import entrada.Teclado;
import modelo.Fecha;
import modelo.Jugador;

public class Main {


	/**
	 * Metodo con el menu que queremos imprimir
	 * @return Devuelve una string con el texto a imprimir
	 */
	public static String texto() {
		return 	  "0. Salir del programa. \n"
				+ "1. Insertar un jugador en la base de datos.\n"
				+ "2. Consultar todos los jugadores de la base de datos\n"
				+ "3. Consultar un jugador, por código, de la base de datos.\n"
				+ "4. Actualizar un jugador, por código, de la base de datos.\n"
				+ "5. Eliminar un jugador, por código, de la base de datos.\n"
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
			//try {
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
			/*} catch (IOException e) {
				e.printStackTrace();
			} catch (RuntimeException e1) {
				System.out.println(e1.getMessage());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
		} while(opcion!=0);
	}

	public static void insertar(){
		String nombre=Teclado.leerCadena("Dime el nombre del Jugador");
		String fecha=Teclado.leerCadena("Dime la fecha de nacimiento del Jugador");
		String[] dia = fecha.split("/");
		
		if(dia.length==3 && Fecha.esValida(Integer.parseInt(dia[0]),Integer.parseInt(dia[1]),Integer.parseInt(dia[2]))) {
			Fecha fechaBien=new Fecha(Integer.parseInt(dia[0]),Integer.parseInt(dia[1]),Integer.parseInt(dia[2]));
			Jugador jugador = new Jugador(nombre,fechaBien);
			AccesoBaseDatos.insertar(jugador);
			System.out.println("Se ha insertado un jugador en la base de datos.");
		}else {
			System.out.println("Fecha no correcta");
		}
		
		
	}

	
	private static void consultar() {
		List<Jugador> jugadores = AccesoBaseDatos.consultar();
		if (jugadores.size() == 0) {
			System.out.println("No se ha encontrado ningún jugador en la base de datos.\n");
		}
		else {
			for (Jugador jugador : jugadores) {
				System.out.println(jugador.toString());
			}
			System.out.println("Se han consultado " + jugadores.size() + 
			                   " jugadores de la base de datos");
		}
	}
	
	private static void consultarCodigo() {
		int codigo = Teclado.leerEntero("Dime el codigo del Jugador");
		Jugador jugador = AccesoBaseDatos.consultarCodigo(codigo);
		if (jugador==null) {
			System.out.println("No existe ningún jugador con ese código en la base de datos.\n");
		}
		else {
			System.out.println(jugador);
		}
		
	}

	private static void actualizar() {
		int codigo = Teclado.leerEntero("Dime el codigo del Jugador");
		String nombre=Teclado.leerCadena("Dime el nombre del Jugador");
		String fecha=Teclado.leerCadena("Dime la fecha de nacimiento del Jugador");
		String[] dia = fecha.split("/");
		
		if(dia.length==3 && Fecha.esValida(Integer.parseInt(dia[0]),Integer.parseInt(dia[1]),Integer.parseInt(dia[2]))) {
			Fecha fechaBien=new Fecha(Integer.parseInt(dia[0]),Integer.parseInt(dia[1]),Integer.parseInt(dia[2]));
			AccesoBaseDatos.actualizar(codigo,nombre,fechaBien);
			System.out.println("Se ha insertado un jugador en la base de datos.");
		}else {
			System.out.println("Fecha no correcta");
		}
		
		
	}
	
	private static void eliminarClase() {
		int codigo = Teclado.leerEntero("Dime el codigo del Jugador");
		Jugador jugador = AccesoBaseDatos.consultarCodigo(codigo);
		if(jugador!=null) {
			List equipos =AccesoBaseDatos.consultarEquipo(codigo);
			if(equipos.size()!=0) {
				System.out.println("Se ha encontrado un equipo relacionado con ese jugador en la base de datos.");
				System.out.println(equipos);
			}else {
				AccesoBaseDatos.eliminar(codigo);
				System.out.println("Se ha eliminado un jugador de la base de datos.");
			}
		}else {
			System.out.println("No existe ningún jugador con ese código en la base de datos.");
		}
		
	}




}
