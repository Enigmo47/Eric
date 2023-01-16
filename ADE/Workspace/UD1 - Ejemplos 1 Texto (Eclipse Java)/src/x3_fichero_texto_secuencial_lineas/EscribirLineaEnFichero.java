package x3_fichero_texto_secuencial_lineas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entrada.Teclado;

public class EscribirLineaEnFichero {

	// Lee por teclado una frase y
	// escribe una línea con esta frase al final del fichero de texto 'frases_sec.txt'.
	public static void main(String[] args) {
		BufferedWriter flujoSalida = null;
		try {
			File fichero = new File("data\\frases_sec.txt");
			flujoSalida = new BufferedWriter(new FileWriter(fichero, true));
			String frase = Teclado.leerCadena("¿Frase? ");
			flujoSalida.write(frase);
			flujoSalida.newLine();
			System.out.println("Se ha escrito una línea en el fichero de texto.");
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
