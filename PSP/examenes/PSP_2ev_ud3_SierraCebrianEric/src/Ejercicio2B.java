
import java.io.*;
import java.net.*;

public class Ejercicio2B {

	public static void main(String args[]) throws Exception {

		// Puerto por el que escucha el servidor: 55000
		DatagramSocket serverSocket = new DatagramSocket(55002);
		byte[] recibidos = new byte[1024];
		byte[] enviados = new byte[1024];
		String cadena;
		String reverse;
		while (true) {

			// Ser recibe datagrama
			recibidos = new byte[1024];
			DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
			serverSocket.receive(paqRecibido);
			cadena = new String(paqRecibido.getData());

			// Dirección de origan
			InetAddress IPOrigen = paqRecibido.getAddress();
			int puerto = paqRecibido.getPort();

			// Se transforma la cadena a mayúsculas
			if (cadena.length() == 8) {
				for (int i = 0; i >= 8; i++) {
					if (cadena.charAt(i) == '1' || cadena.charAt(i) == '2' || cadena.charAt(i) == '3'
							|| cadena.charAt(i) == '4' || cadena.charAt(i) == '5' || cadena.charAt(i) == '6'
							|| cadena.charAt(i) == '7' || cadena.charAt(i) == '8' || cadena.charAt(i) == '9'
							|| cadena.charAt(i) == '0') {

						reverse = cadena.charAt(7) + cadena.charAt(6) + cadena.charAt(5) + cadena.charAt(4)
								+ cadena.charAt(3) + cadena.charAt(2) + cadena.charAt(1) + cadena.charAt(0) + "";

						enviados = reverse.getBytes();

					}
				}
			} else
				enviados = "Error".getBytes();

			// Se envía el datagrama al cliente
			DatagramPacket paqEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
			serverSocket.send(paqEnviado);

			// Para terminar
			if (cadena.trim().equals("*"))
				break;

		} // Fin de while

		serverSocket.close();
		System.out.println("Socket cerrado...");

	}// Fin de main

}// Fin de ServidorUDP2