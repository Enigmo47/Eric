package prueba;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;

public class Aleatorio {

	public static void main(String[] args) {
		String line;
		try {
			File directorio = new File(".\\bin");
			ProcessBuilder pb = new ProcessBuilder("java", "GeneraAleatorio");
			pb.directory(directorio);
			Process hijo = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			PrintStream ps = new PrintStream(hijo.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while ((in.readLine()).compareTo("fin") != 0) {
				ps.println("");
				ps.flush();
				if ((line = br.readLine()) != null) {
					System.out.println(line);
				}

			}
		} catch (IOException ioe) {
			System.out.println("Error");
		}
	}

}
