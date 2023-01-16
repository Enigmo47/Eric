package prueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;

public class GeneraAleatorio {
	
public static void main(String[] args) throws IOException {
	Random rdn = new Random();
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String linea = in.readLine();
	PrintStream ps = new PrintStream(System.out);
	while(in.readLine()!= null) {
		int numero = rdn.nextInt(11);
		ps.println(numero);
		ps.flush();
		linea = in.readLine();
	}
	System.exit(0);
}

}
