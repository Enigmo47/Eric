package x4_fichero_texto_secuencial_objetos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entrada.Teclado;

public class EscribirAlumnoEnFichero {

	// Lee por teclado los datos de un alumno y
	// escribe este alumno al final del fichero de texto 'alumnos_sec.txt'.
	public static void main(String[] args) {
		BufferedWriter flujoSalida = null;
		try {
			File fichero = new File("data\\alumnos_sec.txt");
			flujoSalida = new BufferedWriter(new FileWriter(fichero, true));
			int codigo = Teclado.leerNatural("¿Código? ");
			String nombre = Teclado.leerCadena("¿Nombre? ");
			double nota = Teclado.leerReal("¿Nota? ");
			Alumno alumno = new Alumno(codigo, nombre, nota);
			flujoSalida.write(alumno.toStringWithSeparators());
			flujoSalida.newLine();
			System.out.println("Se ha escrito un alumno en el fichero de texto.");
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
