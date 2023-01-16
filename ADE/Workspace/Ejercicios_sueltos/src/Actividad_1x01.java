
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Actividad_1x01 {

	public static void main(String[] args) {
		
		BufferedWriter salida = null; // declaramos el archivo de entrada
		BufferedReader entrada = null; // declaramos el archivo de salida
		
		try {
			File archivo1 = new File("data\\entrada.txt");
			File archivo2 = new File("data\\salida.txt");
			salida = new BufferedWriter(new FileWriter(archivo2)); //instanciamos archivo entrada
			entrada = new BufferedReader(new FileReader(archivo1));  //instanciamos archivo salida
			
			List<String> texto =new ArrayList<String>();
			List<String> alreves =new ArrayList<String>();
			
			/**
			 * El texto  se introduce en el array de texto
			 */
			String linea = entrada.readLine();
			while (linea != null) { 
				texto.add(linea);
      			linea = entrada.readLine();
      		}
			/**
			 * Se le da la vuelta dentro de el array alreves
			 */
			for(int i=texto.size()-1; i>=0;i--) {
				alreves.add(texto.get(i)+"\n");
			}
			/**
			 * Se añade al archivo de salida
			 */
			for(String line: alreves) {
				salida.write(line);
			}
			
		} catch (IOException e) {
			System.out.println("Error al leer o escribir en el fichero");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if (entrada != null) {
					entrada.close();
				}
				if (salida != null) {
					salida.close();
				}
			}catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero:");
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			}
		}
	}

}
