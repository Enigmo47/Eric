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
	
	public static void main(String[] args) throws IOException {
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
					AccesoDepartamento.CrearDepartamento();
					break;
					
				case 2:
					AccesoDepartamento.ConsultarDepartamento();
					break;
					
				case 3:
					AccesoDepartamento.ConsultarDepartamentoC();
					break;
				case 4:
					
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
				}
			}while(opcion!=0);
		} catch (RuntimeException e1) {
			System.out.println(e1.getMessage());
		}

	}
}
