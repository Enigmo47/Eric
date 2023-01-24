package ActividadChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad1x09Servidor {

	public static void main(String[] args) {
		int numeroPuerto = 60000;// Puerto
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(numeroPuerto);

			while (true) {
				Socket cliente = servidor.accept();
				Actividad1x09Hilo hiloCliente = new Actividad1x09Hilo(cliente,0);
				hiloCliente.start();
			}
		} catch (IOException ioe) {
			ioe.toString();
		} finally {
			if (servidor != null) {
				try {
					servidor.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}