package x1_archivos;

import java.io.File;
import java.io.IOException;

public class CrearDirectorioConFicheros {
	
	// Crea un directorio 'dir'.
	// Crea dos ficheros 'fich1.txt' y 'fich2.txt' dentro del directorio dir.
	// Renombra el fichero 'fich1.txt' por 'fich1renombrado.txt'.
	// Elimina el fichero 'fich2.txt'.
	public static void main(String[] args) {
		File directorio = new File("dir");
		File fichero1 = new File(directorio, "fich1.txt");
		File fichero2 = new File(directorio, "fich2.txt");
		File ficheroRenombrado = new File(directorio, "fich1renombrado.txt");
		try { 
			if (directorio.mkdir()) {
				System.out.println("Se ha creado el directorio dir.");
			}
			else {
				System.out.println("No se ha podido crear el directorio dir.");
			}
			if (fichero1.createNewFile()) {
				System.out.println("Se ha creado el fichero fich1.txt.");
			}
			else {
				System.out.println("No se ha podido crear el fichero fich1.txt.");
			}
			if (fichero2.createNewFile()) {
				System.out.println("Se ha creado el fichero fich2.txt.");
			}
			else {
				System.out.println("No se ha podido crear el fichero fich2.txt.");
			}
			if (fichero1.renameTo(ficheroRenombrado)) {
				System.out.println("Se ha renombrado el fichero fich1.txt por fich1renombrado.txt.");
			}
			else {
				System.out.println("No se ha podido renombrar el fichero fich1.txt.");
			}
			if (fichero2.delete()) {
				System.out.println("Se ha eliminado el fichero fich2.txt.");
			}
			else {
				System.out.println("No se ha podido eliminar el fichero fich2.txt.");
			}
		} 
		catch (IOException ioe) {
			System.out.println("Error de entrada/salida: " + ioe.toString());
			ioe.printStackTrace();
		}  
	}
	
}
