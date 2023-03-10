package Ejercicio3;

import java.io.*;
import java.net.*;
import java.math.*;

public class Actividad1x03Servidor {

	public static void main(String[] arg) throws IOException {

		int numeroPuerto = 60000;// Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente.....");
		clienteConectado = servidor.accept();

		// Se crea flujo de entrada
		InputStream entrada = null;
		entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		int numero = flujoEntrada.readInt();
		// Recepción de mensaje del cliente
		System.out.println("Recibiendo del CLIENTE: \n\t" + numero);

		// Se crea flujo de salida
		OutputStream salida = null;
		salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);

		// Se envía un mensaje al cliente

		int resultado = numero * numero;

		flujoSalida.writeInt(resultado);

		// Se cierran flujos y sockets
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();

	}// main

}// fin de Ejemplo1Servidor