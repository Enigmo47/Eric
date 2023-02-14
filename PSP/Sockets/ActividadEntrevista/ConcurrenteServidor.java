package ActividadEntrevista;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConcurrenteServidor {


	public static void main(String[] args) {
		int puerto = 60000;// Puerto 
		ServerSocket servidor=null;
		int contador=0;
		Respuestas respuestas = new Respuestas();
		try {
			servidor = new ServerSocket(puerto);
		
			while(true) {
				contador++;
				Socket clienteConectado = servidor.accept(); 
				System.out.println("Clientes: "+contador);
				ConcurrenteServidorHilo hiloCliente = new ConcurrenteServidorHilo(clienteConectado,contador,respuestas);
				hiloCliente.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				servidor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			

	}

}
