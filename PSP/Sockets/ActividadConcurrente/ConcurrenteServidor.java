package ActividadConcurrente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ConcurrenteServidor {


	public static void main(String[] args) {
		int puerto = 60000;// Puerto 
		ServerSocket servidor=null;
		int contador=0;
		try {
			servidor = new ServerSocket(puerto);
		
			while(true) {
				contador++;
				Socket clienteConectado = servidor.accept(); 
				System.out.println("Clientes: "+contador);
				ConcurrenteServidorHilo hiloCliente = new ConcurrenteServidorHilo(clienteConectado,contador);
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
