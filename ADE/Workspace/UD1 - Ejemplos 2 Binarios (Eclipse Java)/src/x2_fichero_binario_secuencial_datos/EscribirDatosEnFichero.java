package x2_fichero_binario_secuencial_datos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import entrada.Teclado;

public class EscribirDatosEnFichero {
	
	// Lee por teclado los datos de un alumno y
	// escribe estos datos al final del fichero binario 'alumnos_sec_datos.dat'.
	public static void main(String[] args) {   
		DataOutputStream flujoSalida = null;
		try {
			File fichero = new File("data\\alumnos_sec_datos.dat");
			flujoSalida = new DataOutputStream(new FileOutputStream(fichero, true));
			int codigo = Teclado.leerNatural("¿Código? ");
			String nombre = Teclado.leerCadena("¿Nombre? ");
			double nota = Teclado.leerReal("¿Nota? ");
			flujoSalida.writeInt(codigo);
			flujoSalida.writeUTF(nombre);
			flujoSalida.writeDouble(nota);
			System.out.println("Se han escrito los datos de un alumno en el fichero binario.");
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
