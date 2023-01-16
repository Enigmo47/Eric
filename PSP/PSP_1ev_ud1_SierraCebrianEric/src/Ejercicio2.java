import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Ejercicio2 {

	public static void main(String[] args) {
		try {
			File directorio = new File(".\\bin"); // Se indica el directorio en el que está
			ProcessBuilder pb = new ProcessBuilder("java", "MultiploDivisor");
			pb.directory(directorio);

			Process hijo = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream())); // lee salida del hijo

			PrintStream ps = new PrintStream(hijo.getOutputStream()); // para enviar datos al hijo

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // lee del usuario (es decir aqui)

			System.out.println("Numero 1:");
			int numero = in.read();
			System.out.println("Numero 2:");
			int numero2 = in.read();
			
			if(numero >= 1 && numero2 >= 1){ 
				
				ps.println(numero);
				ps.println(numero2);
				ps.flush();
				throw new NumberFormatException();
			}
			else {
				System.out.print("Alguno de los numero es incorrecto");
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
