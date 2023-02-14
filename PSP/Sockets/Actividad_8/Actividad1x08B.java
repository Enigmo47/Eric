package Actividad_8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Actividad1x08B {

	public static void main(String[] args) {
		try {
			DatagramSocket serverSocket = new DatagramSocket(55002);
			
			byte[] recibidos = new byte[1024]; 
			byte[] enviados = new byte[1024]; 
			String cadena; 


				recibidos = new byte[1024]; 
				DatagramPacket paqRecibido = new DatagramPacket (recibidos, recibidos.length);
				
				serverSocket.receive(paqRecibido);
				
				cadena = new String(paqRecibido.getData()); 

				InetAddress IPOrigen = paqRecibido.getAddress();

				int puerto = paqRecibido.getPort(); 
				String token = cadena.trim(); 
				if(token.contains("token")){
					enviados = "recibido".getBytes();
				}else {
					enviados = "".getBytes();
				}


				//Se envía el datagrama al cliente
				DatagramPacket paqEnviado = new DatagramPacket (enviados, enviados.length, IPOrigen, puerto); 
				serverSocket.send(paqEnviado);
				

			serverSocket.close(); 
		}catch(IOException e) {
			e.printStackTrace();
		}

	}//Fin de main

}//Fin de ServidorUDP2