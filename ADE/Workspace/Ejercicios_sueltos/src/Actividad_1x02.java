import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entrada.Teclado;

public class Actividad_1x02 {

	public static void main(String[] args) {
		
		String fichero = Teclado.leerCadena("Dime el nombre del fichero");
		File archivo = new File("data/"+fichero+".txt");
		if( (!archivo.isFile()) || (!archivo.isDirectory()) ) {
			System.out.println("El archivo no existe en el sistema de archivos");
		}else {
			if( !archivo.isFile() ) {
				System.out.println("El archivo no es un fichero");
			}else {
				BufferedWriter salida = null;
				BufferedReader entrada = null;
				try {
				File archivo2 = new File("data\\estadisticas.txt");
				List<String> texto =new ArrayList<String>();
				
				salida = new BufferedWriter(new FileWriter(archivo2));
				entrada = new BufferedReader(new FileReader(archivo));
				
				String linea = entrada.readLine();
				while (linea != null) { 
					texto.add(linea);
	      			linea = entrada.readLine();
	      		}
				int contChar = 0;
				int contPal=0;
				int contTotal = 0;
				int contPalTotal=0;
				int lineas=0;
				for(String palabras: texto) {
					for(int contador =0; contador<palabras.length();contador++){
						if(contador==palabras.length()-1) {
							lineas++;
						}
						char caracter = palabras.charAt(contador);
						contChar++;
						if(caracter==' ') {
							contPal++;
						}
					}
					System.out.println("Línea "+ lineas +": "+contChar+" caracteres y "+contPal+" palabras");
					contTotal+=contChar;
					contPalTotal+=contPal;
					contPal=0;
					contChar=0;
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
	}

}
