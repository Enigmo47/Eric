package ActividadConcurrente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConcurrenteServidorHilo extends Thread {

	private Socket client;
	private int numero;

	public ConcurrenteServidorHilo(Socket client, int numero) {
		this.client = client;
		this.numero=numero;
	}

	public void run(){

		PrintWriter fsalida=null;
		BufferedReader fentrada=null;
		String pregunta="";
		String respuesta="";
		try {
			fsalida= new PrintWriter(client.getOutputStream(),true);
			fentrada= new BufferedReader(new InputStreamReader(client.getInputStream()));
			for(int i =1; i<=3;i++) {
				pregunta=fentrada.readLine();
				respuesta=comprobarPregunta(pregunta);
				fsalida.println(i+". "+respuesta);
				System.out.println("Cliente numero "+numero+" pregunta "+i);
			}
		
		System.out.println("Cerrando conexion... ");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		fsalida.close();
		try {
			fentrada.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public String comprobarPregunta(String pregunta) {
	String respuesta="";
	switch (pregunta) {
	case "¿Que hora es?": {
		DateTimeFormatter formato= DateTimeFormatter.ofPattern("HH:mm:ss");
		respuesta=LocalDateTime.now().format(formato);
		break;
	}
	case "¿Que dia es?": {
		DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/YYYY");
		respuesta=LocalDateTime.now().format(formato);
		break;
	}
	default:
		respuesta="No te entiendo";
	}
	return respuesta;
}
}
