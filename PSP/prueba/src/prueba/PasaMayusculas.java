package prueba;
/**CLASE HIJO
 * SOLO SYSTEM
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class PasaMayusculas {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // recoge/lee info del padre
		PrintStream ps= new PrintStream(System.out); // se comunica con la clase padre (envia info)

		String linea=in.readLine();

		while(linea != null) {
			ps.println(linea.toUpperCase());// recoge la frase del padre y la convierte en mayusculas
			ps.flush(); // asegura que los datos se han enviado
			linea=in.readLine();
		}
		System.exit(0); // dice que todo va bien
	}

}
