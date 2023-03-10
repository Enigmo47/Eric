package Ejercicio2;


import java.io.*; 
import java.net.*;
import entrada.Teclado;

public class Actividad1x02Cliente { 
	
	public static void main(String[] args) throws Exception { 
		
		String host = "localhost"; 
		int puerto = 60000;//puerto remoto 
		Teclado tec = new Teclado();
		
		String cadena = tec.leerCadena("Introduce una cadena: ");
		
		//System.out.println("PROGRAMA CLIENTE INICIADO...."); 
		Socket cliente = new Socket(host, puerto); 
		
		// Se crea flujo de salida al servidor
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream()); 
		
		// Se envía un mensaje al servidor 
		flujoSalida.writeUTF(cadena); 
		
		// Se crea flujo de entrada del servidor
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream()); 
		
		// Se recibe mensaje enviado del servidor   
		System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF()); 
		
		// Se cierran flujos y sockets
		flujoEntrada.close(); 
		flujoSalida.close(); 
		cliente.close(); 
		
	}// fin de main 
	
}// Fin de Ejemplo1Cliente