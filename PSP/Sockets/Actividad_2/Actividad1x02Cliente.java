package Actividad_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import entrada.Teclado;

public class Actividad1x02Cliente {

	public static void main(String[] args) {
		Socket cliente=null;
		String host = "localhost"; 
		int puerto = 60000;//puerto remoto 
		
		// ABRIR SOCKET 
		try {
			cliente = new Socket(host, puerto);
			String cadena=Teclado.leerCadena("Dime la cadena de texto: ");
			
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream()); 
			System.out.print("Se envia: "+cadena+"\n");
			flujoSalida.writeUTF(cadena);
			
			
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream()); 
			System.out.println("Se recibe: "+flujoEntrada.readUTF()); 
			
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
