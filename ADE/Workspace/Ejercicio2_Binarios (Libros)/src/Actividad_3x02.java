import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entrada.Teclado;



public class Actividad_3x02 {

	/**
	 * Metodo con el menu que queremos imprimir
	 * @return Devuelve una string con el texto a imprimir
	 */
	public static String texto() {
		return 	  "0. Salir del programa. \n"
				+ "1. Insertar un libro en el fichero binario.\n"
				+ "2. Consultar todos los libros del fichero binario.\n"
				+ "3. Consultar un libro, por c贸digo, del fichero binario\n"
				+ "4. Actualizar un libro, por c贸digo, del fichero binario.\n"
				+ "5. Eliminar un libro, por c贸digo, del fichero binario";
	}

	/**
	 * Desde este main se ejecutara el switch con las distintas opciones que contempla el menu
	 */
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
					imprimirFichero();
					break;

				case 3:
					consultarCodigo();
					break;

				case 4:
					actualizar();
					break;
				case 5:
					eliminar();
					break;
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
				}
			}while(opcion!=0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e1) {
			System.out.println(e1.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void insertar() throws NumberFormatException, ClassNotFoundException, IOException {
		String fecha[];
		int codigo=Teclado.leerEntero("Dime el codigo del libro");
		if(AccesoLibro.comprobar(codigo)==null) { // si no fuera null significa que ya existe
			int codigo_escritor=Teclado.leerEntero("Dime el codigo del escritor del libro");
			if(AccesoLibro.comprobarEscritor(codigo_escritor)) {
				String titulo=Teclado.leerCadena("Dime el titulo del libro");
				String ano_publicacion=Teclado.leerCadena("Dime el a帽o de publicacion del libro");
				fecha=ano_publicacion.split("/");
				if(fecha.length <4 && (Integer.parseInt(fecha[2])<= 3000 && Integer.parseInt(fecha[2])>=0) &&
						(Integer.parseInt(fecha[1])<= 12 && Integer.parseInt(fecha[1])>=1) &&
						(Integer.parseInt(fecha[0])<= 31 && Integer.parseInt(fecha[0])>=1)) {
					double precio=Teclado.leerReal("Dime el precio del libro");
					Libro emps = new Libro(codigo,codigo_escritor,titulo,ano_publicacion,precio);
					AccesoLibro.insertar(emps);
				}else{
					System.out.println("Fecha introducida no valida");
				}
			}else {
				System.out.println("No existe ning煤n escritor con ese c贸digo en el fichero de texto.");
			}
		}else {
			System.out.println("Ya existe otro libro con ese c贸digo en el fichero de texto.");
		}
	}

	public static void imprimirFichero() throws IOException, ClassNotFoundException{
		List <Libro> lista = AccesoLibro.ListarLibros();
		if(lista.size() == 0) {
			System.out.println("El fichero binario no tiene ning煤n libro.");
		}else {
			for(Libro l: lista) {
				System.out.println(l.toString());
			}
			System.out.println("Se han consultado " + lista.size() + " libros del fichero de texto.");
		}
	}

	private static void consultarCodigo() throws IOException, ClassNotFoundException {
		int codigo = Teclado.leerEntero("Dime el codigo del departamento");
		Libro d = AccesoLibro.comprobar(codigo);
		if (d!=null) {
			System.out.println(d);
		}else {
			System.out.println("No existe ningun libro con ese codigo en el fichero de texto.");
		}
	}

	private static void actualizar() throws IOException, ClassNotFoundException {
		String fecha[];
		int codigo = Teclado.leerEntero("Dime el codigo del libro");
		if(AccesoLibro.comprobar(codigo)!=null) {
			int codigo_escritor=Teclado.leerEntero("Dime el codigo del escritor del libro");
			if(AccesoLibro.comprobarEscritor(codigo_escritor)) {
				String titulo=Teclado.leerCadena("Dime el titulo del libro");
				String ano_publicacion=Teclado.leerCadena("Dime el a帽o de publicacion del libro");
				fecha=ano_publicacion.split("/");
				if(fecha.length <4 && (Integer.parseInt(fecha[2])<= 3000 && Integer.parseInt(fecha[2])>=0) &&
						(Integer.parseInt(fecha[1])<= 12 && Integer.parseInt(fecha[1])>=1) &&
						(Integer.parseInt(fecha[0])<= 31 && Integer.parseInt(fecha[0])>=1)) {
					double precio=Teclado.leerReal("Dime el precio del libro");

					Libro lib = new Libro(codigo,codigo_escritor,titulo,ano_publicacion,precio);
					AccesoLibro.actualizar(lib);
					System.out.println("Se ha actualizado el libro en el fichero de texto.");

				}else{
					System.out.println("Fecha introducida no valida");
				}
			}else {
				System.out.println("No existe ning鷑 escritor con ese c骴igo en el fichero binario.");
			}
		}else {
			System.out.println("No existe ningun libro con ese codigo en el fichero de texto.");
		}
	}

	private static void eliminar() throws IOException, ClassNotFoundException {
		int codigo = Teclado.leerEntero("Dime el codigo del libro");
		if(AccesoLibro.comprobar(codigo)!=null) {
			Libro l =AccesoLibro.comprobar(codigo);
			if(!(AccesoLibro.comprobarEscritor(l.getCodigo_escritor()))) {
				AccesoLibro.eliminar(codigo);
				System.out.println("Se ha eliminado el libro del fichero de texto.");
			}else {
				System.out.println("Existe al menos un escritor referenciado a ese libro.");
			}
		}else {
			System.out.println("No existe ningun libro con ese codigo en el fichero de texto.");
		}
	}


}
