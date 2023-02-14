package Actividad_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad1x04Servidor {

	public static void main(String[] args) {
		int puerto = 60000;// Puerto 
		ServerSocket servidor=null;
		
		try {
			servidor = new ServerSocket(puerto);
			
			Socket clienteConectado = null; 
			clienteConectado = servidor.accept(); 
			
			InputStream entrada = null; 
			entrada = clienteConectado.getInputStream(); 
			DataInputStream flujoEntrada = new DataInputStream(entrada); 
			

			String cadena=flujoEntrada.readUTF(); 
			System.out.println(cadena);
			
			
			
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
