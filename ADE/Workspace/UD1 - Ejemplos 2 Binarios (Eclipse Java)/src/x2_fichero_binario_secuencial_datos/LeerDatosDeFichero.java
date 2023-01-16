package x2_fichero_binario_secuencial_datos;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerDatosDeFichero {
	
	// Lee todos los datos de alumnos del fichero binario 'alumnos_sec_datos.dat',
	// escribe en consola estos datos de alumnos y
	// escribe en consola el número de alumnos leídos del fichero binario.
	public static void main(String[] args) {
		DataInputStream flujoEntrada = null;
		try {
			File fichero = new File("data\\alumnos_sec_datos.dat");
			flujoEntrada = new DataInputStream(new FileInputStream(fichero));
			int contadorAlumnos = 0;
			try {
				while (true) {
					int codigo = flujoEntrada.readInt();
					String nombre = flujoEntrada.readUTF();
					double nota = flujoEntrada.readDouble();
					System.out.printf("Código = %d, Nombre = %s, Nota = %.6f \n",
					                  codigo, nombre, nota);
					contadorAlumnos++;
				}
			}
			catch (EOFException eofe) {
				System.out.println("Se ha alcanzado el final del fichero binario.");
			}
			System.out.println("Se han leído " + contadorAlumnos + 
			                   " alumnos del fichero binario.");
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
