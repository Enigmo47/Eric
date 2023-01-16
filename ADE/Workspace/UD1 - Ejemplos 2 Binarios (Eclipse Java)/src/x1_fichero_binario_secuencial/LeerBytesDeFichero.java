package x1_fichero_binario_secuencial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerBytesDeFichero {
	
	// Lee byte a byte todas las frases del fichero binario 'frases_sec.dat',
	// escribe en consola estas frases y
	// escribe en consola el número de bytes leídos del fichero binario.
	public static void main(String[] args) {
		FileInputStream flujoEntrada = null;
		try {
			File fichero = new File("data\\frases_sec.dat");
			flujoEntrada = new FileInputStream(fichero);
			int contadorBytes = 0;
			int codigo = flujoEntrada.read();
			while (codigo != -1) {
				System.out.print((char) codigo);
				contadorBytes++;
				codigo = flujoEntrada.read();
			}
			System.out.println("Se han leído " + contadorBytes + 
			                   " bytes del fichero binario.");
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
