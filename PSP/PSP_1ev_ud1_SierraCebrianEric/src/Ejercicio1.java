import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Ejercicio1 {
	/**
	 * 
	 * //
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Runtime runtime = Runtime.getRuntime();

			Process hijo = runtime.exec("java Referencia", null, new File(".\\bin"));

			BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream())); // lee salida del hijo

			PrintStream ps = new PrintStream(hijo.getOutputStream()); // para enviar datos al hijo

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // lee del usuario (es decir aqui)

			System.out.println("Escriba un codigo: ");
			String codigo = in.readLine();

			do { // mientras lo que escriba el usuario no sea fin, sigue haciendo
					// esto
				if (codigo.charAt(0) == 'A' && codigo.charAt(0) == 'B') {

					if (codigo.charAt(1) == '0' && codigo.charAt(1) == '1') {

						if (codigo.charAt(2) == '1' && codigo.charAt(2) == '9') {

							if (codigo.charAt(3) == '9') {

								ps.println(codigo); // no es necesario escribir nada
								ps.flush();

								String lcodigo = br.readLine();
								System.out.println(lcodigo);

								System.out.println("Escriba un codigo: ");
								codigo = in.readLine(); // vuelves a leer otra linea
							}
						}
					}
				}else {
					System.out.println("Codigo no valido");
					System.out.println("Escriba un codigo: ");
					codigo = in.readLine();
				}
			} while (codigo != "0000");
			
			//No sé el motivo por el cual siempre me sale al else , no soy capáz de encontrar el error

			hijo.destroy();
			System.out.println("Finalizado");
		} catch (IOException ex) {
			System.err.println("Error de Entrada/Salida" + ex.toString());
			System.exit(-1);
		}

	}

}
