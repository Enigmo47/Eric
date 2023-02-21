
import java.io.*;
import java.net.*;

public class Ejercicio2A {

	public static void main(String args[]) throws Exception {

		// Flujo de entrada estándar
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		DatagramSocket clientSocket = new DatagramSocket(50000);// socket cliente
		byte[] enviados = new byte[1024];
		byte[] recibidos = new byte[1024];

		// Datos del servidor
		InetAddress IPServidor = InetAddress.getLocalHost();// localhost
		int puerto = 55002; // puerto por el que escucha

		// Se solicitan los datos por teclado
		System.out.print("Introduce 8 numeros: ");
		String cadena = in.readLine();
		enviados = cadena.getBytes();

		// Se envía el datagrama al servidor
		System.out.println("Enviando " + enviados.length + " bytes al servidor.");
		DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
		clientSocket.send(envio);

		// Se recibe el datagrama del servidor
		DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
		System.out.println("Esperando datagrama....");
		clientSocket.receive(recibo);
		String reverse = new String(recibo.getData());

		// Se obtiene información del datagrama

		System.out.println(reverse);

		// cerrar socket
		clientSocket.close();

	}// Fin de main

}// Fin de ClienteUDP2
