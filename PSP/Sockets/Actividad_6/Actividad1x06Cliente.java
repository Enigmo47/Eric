package Actividad_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import entrada.Teclado;

public class Actividad1x06Cliente {

	public static void main(String[] args) {
		String host = "localhost"; 
		int puerto = 60000;//puerto remoto 
		int contador=0;
		Socket cliente=null;
		
		// ABRIR SOCKET 
		
		try {
			cliente = new Socket(host, puerto);
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream()); 
			System.out.println(flujoEntrada.readInt());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
