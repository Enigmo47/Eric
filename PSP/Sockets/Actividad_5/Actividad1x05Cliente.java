package Actividad_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import entrada.Teclado;

public class Actividad1x05Cliente {

	public static void main(String[] args) {
		String host = "localhost"; 
		int puerto = 60000;//puerto remoto 
		Socket cliente=null;
		
		// ABRIR SOCKET 
		try {
			cliente = new Socket(host, puerto);
			String cadena="";
			do {
			cadena=Teclado.leerCadena("Preguntame algo");
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream()); 
			flujoSalida.writeUTF(cadena);
			
			
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream()); 
			System.out.println(flujoEntrada.readUTF()); 
			}while(!cadena.equals("?"));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				cliente.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
