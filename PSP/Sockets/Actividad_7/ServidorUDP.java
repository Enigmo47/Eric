package Actividad_7;

import java.io.*; 
import java.net.*; 

public class ServidorUDP { 
	
	public static void main(String args[]) throws Exception { 
		
		//Puerto por el que escucha el servidor: 55000 
		DatagramSocket serverSocket = new DatagramSocket(55002); 
		byte[] recibidos = new byte[1024]; 
		byte[] enviados = new byte[1024]; 
		String cadena; 
		
		while(true) { 
			
			//Ser recibe datagrama
			recibidos = new byte[1024]; 
			DatagramPacket paqRecibido = new DatagramPacket (recibidos, recibidos.length);
			serverSocket.receive(paqRecibido); 
			cadena = new String(paqRecibido.getData()); 
			
			//Dirección de origan
			InetAddress IPOrigen = paqRecibido.getAddress(); 
			int puerto = paqRecibido.getPort(); 
			
			//Se transforma la cadena a mayúsculas
			String mayuscula = cadena.trim().toUpperCase(); 
			if(mayuscula.contains("HOLA")){
				enviados = "¿Qué tal?".getBytes();
			}else {
				enviados = "".getBytes();
			}
			 
			
			//Se envía el datagrama al cliente
			DatagramPacket paqEnviado = new DatagramPacket (enviados, enviados.length, IPOrigen, puerto); 
			serverSocket.send(paqEnviado); 
			
			//Para terminar 
			if(cadena.trim().equals("*")) break;
			
		}//Fin de while
		
		serverSocket.close(); 
		System.out.println ("Socket cerrado..."); 
	
	}//Fin de main
	
}//Fin de ServidorUDP2