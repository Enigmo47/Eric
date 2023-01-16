package x3_fichero_binario_secuencial_objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import entrada.Teclado;

public class EscribirAlumnoEnFichero2 {

	// Lee por teclado los datos de un alumno y
	// escribe este alumno al final del fichero binario 'alumnos_sec_objetos.dat'.
	// Considera dos casos:
	// - Si el fichero binario no existe, lo crea e inserta el alumno al principio
	//   del fichero binario (añadiendo una cabecera al objeto).
	// - Si el fichero binario existe, inserta el alumno al final del fichero binario
	//   (no añadiendo otra cabecera al objeto).
	public static void main(String[] args) {
		ObjectOutputStream flujoSalida1 = null;
		MyObjectOutputStream flujoSalida2 = null;
		try {
			int codigo = Teclado.leerNatural("¿Código? ");
			String nombre = Teclado.leerCadena("¿Nombre? ");
			double nota = Teclado.leerReal("¿Nota? ");
			Alumno alumno = new Alumno(codigo, nombre, nota);
			File fichero = new File("data\\alumnos_sec_objetos.dat");
			// Insertar el alumno al final del fichero.
			if (fichero.exists()) {
				flujoSalida2 = new MyObjectOutputStream(new FileOutputStream(fichero, true));
				flujoSalida2.writeObject(alumno);
			}
			// Crear el fichero e insertar el alumno al principio del fichero.
			else {
				flujoSalida1 = new ObjectOutputStream(new FileOutputStream(fichero));
				flujoSalida1.writeObject(alumno);
			}
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
				if (flujoSalida1 != null) {
					flujoSalida1.close();
				}
				if (flujoSalida2 != null) {
					flujoSalida2.close();
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
