package prueba;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * CLASE PADRE AQUI SOLO STREAMS
 * 
 * @author Eric Sierra Cebrian
 *
 */
public class Mayusculas {

	public static void main(String[] args) {


		try {
			File directorio = new File(".\\bin"); // Se indica el directorio en el que está
			ProcessBuilder pb = new ProcessBuilder("java", "prueba/PasaMayusculas");
			pb.directory(directorio);

			Process hijo = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream())); // lee salida del hijo

			PrintStream ps = new PrintStream(hijo.getOutputStream()); // para enviar datos al hijo

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // lee del usuario (es decir aqui)

			System.out.println("Escribe una frase para pasarla a mayusculas: ");
			String linea = in.readLine();

			while (linea.compareTo("fin") != 0) { // mientras lo que escriba el usuario no sea fin, sigue haciendo esto
				ps.println(linea); // no es necesario escribir nada
				ps.flush();

				String lineaMayus = br.readLine();
				System.out.println(lineaMayus);

				System.out.println("Escribe una frase para pasarla a mayusculas: ");
				linea = in.readLine(); // vuelves a leer otra linea
			}
			hijo.destroy();
			System.out.println("Finalizado");
		} catch (IOException ex) {
			System.err.println("Error de Entrada/Salida" + ex.toString());
			System.exit(-1);
		}
	}
}