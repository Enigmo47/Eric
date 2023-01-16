import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MultiploDivisor {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // recoge/lee info del padre
		PrintStream ps= new PrintStream(System.out); // se comunica con la clase padre (envia info)

		int numero =in.read();
		
		int numero2 = in.read();

		if (numero % numero2 == 0) {
			ps.println("Resultado: Multiplo");// recoge la frase del padre y la convierte en mayusculas
			ps.flush(); // asegura que los datos se han enviado
			numero=in.read();
			numero2=in.read();
		}
		else {
			System.out.print("Resultado: No estan relacionados");
		}
		System.exit(0); // dice que todo va bien

	}

}
