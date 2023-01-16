package prueba;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Primos {
	public static void main(String[] args) {


		try {
			File directorio = new File(".\\bin"); // Se indica el directorio en el que está
			ProcessBuilder pb = new ProcessBuilder("java", "prueba/PasaPrimos");
			pb.directory(directorio);

			Process hijo = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream())); // lee salida del hijo

			PrintStream ps = new PrintStream(hijo.getOutputStream()); // para enviar datos al hijo

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // lee del usuario (es decir aqui)

			String linea = in.readLine();
			
			int numero = Integer.parseInt(in.readLine());
			if(numero < 1) throw new NumberFormatException ();
			
				ps.println(numero);
				ps.flush();

				while((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
				in.close();
				hijo.destroy();
			
		}
		
		catch (NumberFormatException nfe) {
			System.err.println("Error de Entrada/Salida" + nfe.toString());
			System.exit(-1);
		}
		
		catch (IOException ex) {
			System.err.println("Error de Entrada/Salida" + ex.toString());
			System.exit(-1);
		}
	}
}
