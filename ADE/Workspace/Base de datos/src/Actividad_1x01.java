import java.io.IOException;
import java.util.ArrayList;

import entrada.Teclado;

public class Actividad_1x01 {
	
	public static String texto() {
		return 	  "0. Salir del programa. \n"
				+ "1. Insertar un departamento en el fichero de texto.\n"
				+ "2. Consultar todos los departamentos del fichero de texto.\n"
				+ "3. Consultar un departamento, por codigo, del fichero de texto.\n"
				+ "4. Actualizar un departamento, por codigo, del fichero de texto.\n"
				+ "5. Eliminar un departamento, por codigo, del fichero de texto";
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
					int codigo=Teclado.leerEntero("Dime el codigo del departamento");
					String nombre=Teclado.leerCadena("Dime el nombre del departamento");
					String ubicacion=Teclado.leerCadena("Dime la ubicacion de departamento");
					AccesoDepartamento.CrearDepartamento(nombre,ubicacion);
					break;
					
				case 2:
				
					break;
					
				case 3:
					
					break;
				case 4:
					
					
					
					break;
				case 5:
					
					
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
		}

	}
}
