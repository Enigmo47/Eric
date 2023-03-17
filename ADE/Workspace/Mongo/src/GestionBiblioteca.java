

import entrada.Teclado;

public class GestionBiblioteca {

	/**
	 * Metodo con el menu que queremos imprimir
	 * 
	 * @return Devuelve una string con el texto a imprimir
	 */
	public static String texto() {
		return "0. Salir del programa. \n" 
				+ "1. Insertar un libro en la base de datos.\n"
				+ "2.  Consultar todos los libros de la base de datos.\n" 
				+ "3. Consultar un libro, por código, de la base de datos.\n"
				+ "4. Actualizar un libro, por código, de la base de datos. \n"
				+ "5. Eliminar un libro, por código, de la base de datos.";
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
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (opcion != 0);
	}






}
