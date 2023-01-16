package x3_fichero_texto_secuencial_lineas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerLineasDeFichero {

	// Lee línea a línea todas las frases del fichero de texto 'frases_sec.txt',
	// escribe en consola estas frases y
	// escribe en consola el número de frases leídas del fichero de texto.
	public static void main(String[] args) {
		BufferedReader flujoEntrada = null;
		try {
			File fichero = new File("data\\frases_sec.txt");
			flujoEntrada = new BufferedReader(new FileReader(fichero));
			int contadorLineas = 0;
      		String linea = flujoEntrada.readLine(); 
      		while (linea != null) { 	 
      			System.out.println(linea);
      			contadorLineas++;
      			linea = flujoEntrada.readLine();
      		}
      		System.out.println("Se han leído " + contadorLineas + 
      		                   " líneas del fichero de texto.");
		}
		catch (FileNotFoundException fnfe) {                      
			System.out.println("Error al abrir el fichero:");
			System.out.println(fnfe.getMessage());
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero:");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
		finally {
			try {
				if (flujoEntrada != null) {
					flujoEntrada.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero:");
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			}
		}
	}
	
}
