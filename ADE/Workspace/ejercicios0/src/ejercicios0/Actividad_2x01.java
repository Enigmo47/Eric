package ejercicios0;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Actividad_2x01 {
public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args){
		try {
			int opción = -1;
			do {
				imprimirMenú();
				System.out.println("Opción del menú:");
				opción = teclado.nextInt();
				teclado.nextLine();
				menú(opción);
			}while(opción != 0);
		}/*
		catch (InputMismatchException ime) {
			System.out.println("Error en el input:");
			System.out.println(ime.getMessage());
			ime.printStackTrace();
		}*/
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero:");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	}
	// 1 FUNCIONA
	public static void insertarDepartamento(Departamento departamento) throws IOException{
		if(AccesoDepartamento.existeDepartamento(departamento))
			System.out.println("Ya existe otro departamento con ese código en el fichero de texto.");
		else {
			AccesoDepartamento.insertarDepartamento(departamento);
			System.out.println("Se ha insertado un departamento en el fichero de texto.");
		}
	}
	// 2 FUNCIONA
	public static void imprimirFichero() throws IOException{
		if(AccesoDepartamento.estáVacio())
			System.out.println("El fichero de texto no tiene ningún departamento.");
		else {
			int contador = 0;
			List <Departamento> lista = AccesoDepartamento.getDeFicheroALista();
			for(Departamento d: lista) {
				contador++;
				System.out.println(d.toString());
			}
			System.out.println("Se han consultado " + contador + " departamentos del fichero de texto.");
		}
		
	}
	// 3 FUNCIONA
	public static void consultarDepartamento(int código) throws IOException {
		if(!AccesoDepartamento.existeDepartamento(código)) 
			System.out.println("No existe ningún departamento con ese código en el fichero de texto");
		else {
			Departamento departamento = AccesoDepartamento.devuelveDepartamento(código);
			System.out.println(departamento.toString());
		}
	}
	// 4 FUNCIONA
	public static void actualizarDepartamento(int código, String nombre, String ubicación) throws IOException{
		Departamento departamento = new Departamento(código, nombre, ubicación);
		if(AccesoDepartamento.existeDepartamento(departamento)) {
			List lista = AccesoDepartamento.eliminarDepartamento(código);
			AccesoDepartamento.getDeListaAFichero(lista);
			AccesoDepartamento.insertarDepartamento(new Departamento(código,nombre,ubicación));
			System.out.println("Se ha actualizado un departamento del fichero de texto.");
		}
		else
			System.out.println("No existe ningún departamento con ese código en el fichero de texto.");
	}
	// 5 FUNCIONA
	public static void eliminarDepartamento(int código) throws IOException {
		if(!AccesoDepartamento.existeDepartamento(código))
			System.out.println("No existe ningún departamento con ese código en el fichero de texto.");
		else {
			List lista = AccesoDepartamento.eliminarDepartamento(código);
			AccesoDepartamento.getDeListaAFichero(lista);
			System.out.println("Se ha eliminado un departamento del fichero de texto.");
		}
	
	}
	public static void imprimirMenú() {
		System.out.println("0) Salir del programa.\n1) Insertar un departamento en el fichero de texto\n"
				+ "2) Consultar todos los departamentos del fichero de texto.\n"
				+ "3) Consultar un departamento, por código, del fichero de texto.\n"
				+ "4) Actualizar un departamento, por código, del fichero de texto.\n"
				+ "5) Eliminar un departamento, por código, del fichero de texto.");
	}
	public static void menú(int opción) throws IOException {
		int código;
		String nombre;
		String ubicación;
		switch (opción) {
		case 0:
			break;
		case 1:
			System.out.println("Código:");
			código = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Nombre:");
			nombre = teclado.nextLine();
			System.out.println("Ubicación:");
			ubicación = teclado.nextLine();
			insertarDepartamento(new Departamento(código,nombre,ubicación));
			break;
		case 2:
			imprimirFichero();
			break;
		case 3:
			System.out.println("Código:");
			código = teclado.nextInt();
			consultarDepartamento(código);
			break;
		case 4:
			System.out.println("Código:");
			código = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Nombre:");
			nombre = teclado.nextLine();
			System.out.println("Ubicación:");
			ubicación = teclado.nextLine();
			actualizarDepartamento(código,nombre,ubicación);
			break;
		case 5:
			System.out.println("Código:");
			código = teclado.nextInt();
			eliminarDepartamento(código);
			break;
		default:
			System.out.println("La opción de menú debe estar comprendida entre 0 y 5.");
		}
	}
}