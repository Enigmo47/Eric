package x4_fichero_texto_secuencial_objetos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerAlumnosDeFichero {
	
	// Lee todos los alumnos del fichero de texto 'alumnos_sec.txt',
	// escribe en consola estos alumnos y
	// escribe en consola el número de alumnos leídos del fichero de texto.
	public static void main(String[] args) {
		BufferedReader flujoEntrada = null;
		try {
			File fichero = new File("data\\alumnos_sec.txt");
			flujoEntrada = new BufferedReader(new FileReader(fichero));
			int contadorAlumnos = 0;
      		String linea = flujoEntrada.readLine(); 
      		while (linea != null) { 	
      			Alumno alumno = new Alumno(linea);
      			System.out.println(alumno.toString());
      			contadorAlumnos++;
      			linea = flujoEntrada.readLine();
      		}
      		System.out.println("Se han leído " + contadorAlumnos + 
      		                   " alumnos del fichero de texto.");
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
		catch (NumberFormatException nfe) {
			System.out.println("Error al convertir de cadena a número:");
			System.out.println(nfe.getMessage());
			nfe.printStackTrace();
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
