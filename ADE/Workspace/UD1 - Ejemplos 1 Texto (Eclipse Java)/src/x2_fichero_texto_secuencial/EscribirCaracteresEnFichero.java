package x2_fichero_texto_secuencial;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entrada.Teclado;

public class EscribirCaracteresEnFichero {

	// Lee por teclado una frase y
	// escribe carácter a carácter esta frase al final del fichero de texto 'frases_sec.txt'.
	public static void main(String[] args) {
		FileWriter flujoSalida = null;
		try {
			File fichero = new File("data\\frases_sec.txt");
			flujoSalida = new FileWriter(fichero, true);
			String frase = Teclado.leerCadena("¿Frase? ");
			flujoSalida.write(frase);
			flujoSalida.write("\r\n");  // salto de línea en Windows
			System.out.println("Se han escrito " + (frase.length() + 2) + 
			                   " caracteres en el fichero de texto.");
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
