package x2_fichero_texto_secuencial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerCaracteresDeFichero {
	
	// Lee car�cter a car�cter todas las frases del fichero de texto 'frases_sec.txt',
	// escribe en consola estas frases y
	// escribe en consola el n�mero de caracteres leídos del fichero de texto.
	public static void main(String[] args) {
		FileReader flujoEntrada = null;
		try {
			File fichero = new File("data\\frases_sec.txt");
			flujoEntrada = new FileReader(fichero);    
			int contadorCaracteres = 0;
			int codigo = flujoEntrada.read();
			while (codigo != -1) {
				System.out.print((char) codigo);
				contadorCaracteres++;
				codigo = flujoEntrada.read();
			}	
			System.out.println("Se han le�do " + contadorCaracteres + 
			                   " caracteres del fichero de texto.");
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
