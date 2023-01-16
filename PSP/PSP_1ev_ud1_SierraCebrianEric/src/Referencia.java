import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Referencia {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // recoge/lee info del padre
		PrintStream ps = new PrintStream(System.out); // se comunica con la clase padre (envia info)
		
		int ref1 = 0;
		int ref2 = 0;
		int ref3 = 0;
		int ref9 = 0;
		String codigo = in.readLine();
		
		int ca2 = (int)(codigo.charAt(1));
		int ca3 = (int)(codigo.charAt(2));

		while (codigo != "0000") {
			
			if (codigo.charAt(0) == 'A' && codigo.charAt(1) <=1 && codigo.charAt(2) == 0) {
				ref1 = ref1 + 1;
			}
			if (codigo.charAt(0) == 'B' && ca2 <=1 && ca3 == 0) {
				ref2 = ref2 + 1;
			}
			if (codigo.charAt(0) == 'A' && ca2 <=1 && ca3 <=9) {
				ref3 = ref3 + 1;
			}
			else {
				ref9 = ref9 + 1;
			}
		
		}
		ps.println("Resumen resultados");
		ps.println("Codigos con REF01:"+ ref1);
		ps.println("Codigos con REF02:"+ ref2);
		ps.println("Codigos con REF03:"+ ref3);
		ps.println("Codigos con REF09:"+ ref9);// recoge la frase del padre y la convierte en mayusculas
		ps.flush(); // asegura que los datos se han enviado
		
		codigo = in.readLine();
		System.exit(0); // dice que todo va bien
	}
}

