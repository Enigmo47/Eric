package prueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class PasaPrimos {

	public static void main(String[] args) throws IOException {
	int divisores = 1;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // recoge/lee info del padre
	PrintStream ps= new PrintStream(System.out); // se comunica con la clase padre (envia info)
	String dato=in.readLine();

	if(dato!= null) {
		int numero = Integer.parseInt(dato);
		if(divisores<=2){
			ps.println(numero + " Es primo");
			ps.flush();
		}
		else {
			ps.println("Los numeros menores a" + numero + "son" + dato);
			ps.flush();
			for(int i = numero-1;i>0;i--) {
				ps.println(i);
				ps.flush();
			}
		}
	}
	
}
}


//Process process =runtime.exec("java ValorRetorno", null, new File(".\\bin"));
//Runtime runtime = Runtime.getRuntime();
//Process hijo = runtime.exec("java ud1x03_runtime/PasaMayusculas", null ,  new File(".\\bin"));