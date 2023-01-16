package x3_fichero_binario_secuencial_objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import entrada.Teclado;

public class EscribirAlumnoEnFichero1 {

	// Lee por teclado los datos de un alumno y
	// escribe este alumno al final del fichero binario 'alumnos_sec_objetos.dat'.
	public static void main(String[] args) {
		ObjectOutputStream flujoSalida = null;
		try {
			int codigo = Teclado.leerNatural("¿Código? ");
			String nombre = Teclado.leerCadena("¿Nombre? ");
			double nota = Teclado.leerReal("¿Nota? ");
			Alumno alumno = new Alumno(codigo, nombre, nota);
			File fichero = new File("data\\alumnos_sec_objetos.dat");
			flujoSalida = new ObjectOutputStream(new FileOutputStream(fichero, true));
			flujoSalida.writeObject(alumno);
			System.out.println("Se ha escrito un alumno en el fichero binario.");
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
