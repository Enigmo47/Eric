package x1_fichero_binario_secuencial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import entrada.Teclado;

public class EscribirBytesEnFichero {
	
	// Lee por teclado una frase y
	// escribe byte a byte esta frase al final del fichero binario 'frases_sec.dat'.
	public static void main(String[] args) {
		FileOutputStream flujoSalida = null;
		try {
			File fichero = new File("data\\frases_sec.dat");
			flujoSalida = new FileOutputStream(fichero, true);
			String frase = Teclado.leerCadena("¿Frase? ");
			for (int posicion = 0 ; posicion < frase.length() ; posicion++) {
				int codigo = frase.charAt(posicion);
				flujoSalida.write(codigo);
			}
			flujoSalida.write('\n');
			System.out.println("Se han escrito " + (frase.length() + 1) + 
			                   " bytes en el fichero binario.");
		} 
		catch (FileNotFoundException fnfe) {
			System.out.println("Error al crear o abrir el fichero:");
			System.out.println(fnfe.getMessage());
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Error al escribir en el fichero:");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
		finally {
			try {
				if (flujoSalida != null) {
					flujoSalida.close();
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
