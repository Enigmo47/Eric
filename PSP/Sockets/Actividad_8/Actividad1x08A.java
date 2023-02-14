package Actividad_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Actividad1x08A {

	public static void main(String[] args) {
		try {
			String token="token";

			// Flujo de entrada estándar
			BufferedReader in = new BufferedReader (new InputStreamReader(System.in)); 

			DatagramSocket clientSocket = new DatagramSocket(50000);  
			byte[] enviados = new byte[1024]; 
			byte[] recibidos = new byte[1024]; 

			// Datos del servidor
			InetAddress IPServidor = InetAddress.getLocalHost();
			
			int puerto = 55002; // puerto por el que escucha 

			// Se solicitan los datos por teclado

			enviados = token.getBytes(); 

			// Se envía el datagrama al servidor
			System.out.println("Enviando " + enviados.length + " bytes al servidor.");
			DatagramPacket envio = new DatagramPacket (enviados, enviados.length, IPServidor, puerto); 
			clientSocket.send(envio);
			 

			// Se recibe el datagrama del servidor
			DatagramPacket recibo = new DatagramPacket (recibidos, recibidos.length); 
			clientSocket.receive(recibo);
			
			String respuesta = new String(recibo.getData()); 

			// Se obtiene información del datagrama

			System.out.println("Datos: " + respuesta.trim()); 

			//cerrar socket
			clientSocket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}//Fin de main

}//Fin de ClienteUDP2