package ActividadChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Actividad1x09Hilo extends Thread {
	private Socket cliente;
	private int numero;

	public Actividad1x09Hilo(Socket cliente, int numero) {
		this.cliente = cliente;
		this.numero = numero;
	}

	@Override
	public void run() {
		PrintWriter fsalida = null;
		BufferedReader fentrada = null;
		try {
			// Se crea flujo de salida al servidor
			fsalida = new PrintWriter(cliente.getOutputStream(), true);
			// Se crea flujo de entrada del servidor
			fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

			for (int i = 1; i <= 3; i++) {
				String pregunta = fentrada.readLine(); // lectura desde cliente
				String respuesta = responder(pregunta);
				fsalida.println("Respuesta número " + i + ": " + respuesta); // envio la respuesta a cliente
				System.out.println("cliente numero "+ numero + "Pregunta:"+ i );
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (fsalida != null)
				fsalida.close();
			if (fentrada != null) {
				try {
					fentrada.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cliente != null) {
				try {
					cliente.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private String responder(String pregunta) {
		String respuesta = "No tengo la respuesta";
		if (pregunta.equals("Qué día es?")) {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			respuesta = LocalDateTime.now().format(formato);
		} else if (pregunta.equals("Qué hora es?")) {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH/mm/ss");
			respuesta = LocalDateTime.now().format(formato);
		}
		return respuesta;
	}
}
