package x3_fichero_binario_secuencial_objetos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class LeerAlumnosDeFichero {
	
	// Lee todos los alumnos del fichero binario 'alumnos_sec_objetos.dat',
	// escribe en consola estos alumnos y
	// escribe en consola el número de alumnos leídos del fichero binario.
	public static void main(String[] args) {
		ObjectInputStream flujoEntrada = null;
		try {
			File fichero = new File("data\\alumnos_sec_objetos.dat");
			flujoEntrada = new ObjectInputStream(new FileInputStream(fichero));
			int contadorAlumnos = 0;
			try {
				while (true) {
					Alumno alumno = (Alumno) flujoEntrada.readObject();
					System.out.println(alumno.toString());
					contadorAlumnos++;
				}
			}
			catch (EOFException eofe) {
				System.out.println("Se ha alcanzado el final del fichero binario.");
			}
			catch (StreamCorruptedException sce) {
				System.out.println("Se ha encontrado información inconsistente en el fichero binario.");
			}
			System.out.println("Se han leído " + contadorAlumnos + 
	                           " alumnos del fichero binario.");
		} 
		catch (ClassNotFoundException cnfe) {
			System.out.println("Error al convertir objeto a una clase:");
			System.out.println(cnfe.getMessage());
			cnfe.printStackTrace();
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
