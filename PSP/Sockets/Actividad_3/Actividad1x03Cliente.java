package Actividad_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import entrada.Teclado;

public class Actividad1x03Cliente {

	public static void main(String[] args) {
		String host = "localhost"; 
		int puerto = 60000;//puerto remoto 
		Socket cliente=null;
		
		// ABRIR SOCKET 
		try {
			cliente = new Socket(host, puerto);
			int num =Teclado.leerEntero("Dime el numero entero: ");
			
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream()); 
			System.out.print("Se envia: "+num+"\n");
			flujoSalida.writeInt(num);
			
			
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream()); 
			System.out.println("Se recibe: "+flujoEntrada.readInt()); 
			
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
