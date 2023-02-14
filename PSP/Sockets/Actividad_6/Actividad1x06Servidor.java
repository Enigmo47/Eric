package Actividad_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad1x06Servidor {

	public static void main(String[] args) {
		int puerto = 60000;// Puerto 
		int contador=0;
		ServerSocket servidor=null;
		OutputStream salida = null; 
		Socket clienteConectado = null; 
		try {
			servidor = new ServerSocket(puerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while(true){ 
				clienteConectado = servidor.accept();
				salida = clienteConectado.getOutputStream(); 
				DataOutputStream flujoSalida = new DataOutputStream(salida); 
				contador++;
				flujoSalida.writeInt(contador);
				clienteConectado.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				servidor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}




	}

}
