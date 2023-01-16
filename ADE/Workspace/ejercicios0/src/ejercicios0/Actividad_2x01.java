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
			int opci�n = -1;
			do {
				imprimirMen�();
				System.out.println("Opci�n del men�:");
				opci�n = teclado.nextInt();
				teclado.nextLine();
				men�(opci�n);
			}while(opci�n != 0);
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
			System.out.println("Ya existe otro departamento con ese c�digo en el fichero de texto.");
		else {
			AccesoDepartamento.insertarDepartamento(departamento);
			System.out.println("Se ha insertado un departamento en el fichero de texto.");
		}
	}
	// 2 FUNCIONA
	public static void imprimirFichero() throws IOException{
		if(AccesoDepartamento.est�Vacio())
			System.out.println("El fichero de texto no tiene ning�n departamento.");
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
	public static void consultarDepartamento(int c�digo) throws IOException {
		if(!AccesoDepartamento.existeDepartamento(c�digo)) 
			System.out.println("No existe ning�n departamento con ese c�digo en el fichero de texto");
		else {
			Departamento departamento = AccesoDepartamento.devuelveDepartamento(c�digo);
			System.out.println(departamento.toString());
		}
	}
	// 4 FUNCIONA
	public static void actualizarDepartamento(int c�digo, String nombre, String ubicaci�n) throws IOException{
		Departamento departamento = new Departamento(c�digo, nombre, ubicaci�n);
		if(AccesoDepartamento.existeDepartamento(departamento)) {
			List lista = AccesoDepartamento.eliminarDepartamento(c�digo);
			AccesoDepartamento.getDeListaAFichero(lista);
			AccesoDepartamento.insertarDepartamento(new Departamento(c�digo,nombre,ubicaci�n));
			System.out.println("Se ha actualizado un departamento del fichero de texto.");
		}
		else
			System.out.println("No existe ning�n departamento con ese c�digo en el fichero de texto.");
	}
	// 5 FUNCIONA
	public static void eliminarDepartamento(int c�digo) throws IOException {
		if(!AccesoDepartamento.existeDepartamento(c�digo))
			System.out.println("No existe ning�n departamento con ese c�digo en el fichero de texto.");
		else {
			List lista = AccesoDepartamento.eliminarDepartamento(c�digo);
			AccesoDepartamento.getDeListaAFichero(lista);
			System.out.println("Se ha eliminado un departamento del fichero de texto.");
		}
	
	}
	public static void imprimirMen�() {
		System.out.println("0) Salir del programa.\n1) Insertar un departamento en el fichero de texto\n"
				+ "2) Consultar todos los departamentos del fichero de texto.\n"
				+ "3) Consultar un departamento, por c�digo, del fichero de texto.\n"
				+ "4) Actualizar un departamento, por c�digo, del fichero de texto.\n"
				+ "5) Eliminar un departamento, por c�digo, del fichero de texto.");
	}
	public static void men�(int opci�n) throws IOException {
		int c�digo;
		String nombre;
		String ubicaci�n;
		switch (opci�n) {
		case 0:
			break;
		case 1:
			System.out.println("C�digo:");
			c�digo = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Nombre:");
			nombre = teclado.nextLine();
			System.out.println("Ubicaci�n:");
			ubicaci�n = teclado.nextLine();
			insertarDepartamento(new Departamento(c�digo,nombre,ubicaci�n));
			break;
		case 2:
			imprimirFichero();
			break;
		case 3:
			System.out.println("C�digo:");
			c�digo = teclado.nextInt();
			consultarDepartamento(c�digo);
			break;
		case 4:
			System.out.println("C�digo:");
			c�digo = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Nombre:");
			nombre = teclado.nextLine();
			System.out.println("Ubicaci�n:");
			ubicaci�n = teclado.nextLine();
			actualizarDepartamento(c�digo,nombre,ubicaci�n);
			break;
		case 5:
			System.out.println("C�digo:");
			c�digo = teclado.nextInt();
			eliminarDepartamento(c�digo);
			break;
		default:
			System.out.println("La opci�n de men� debe estar comprendida entre 0 y 5.");
		}
	}
}