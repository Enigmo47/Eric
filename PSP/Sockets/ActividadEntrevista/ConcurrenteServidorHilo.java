package ActividadEntrevista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConcurrenteServidorHilo extends Thread {

	private Socket client;
	private int numero;
	Respuestas respuestas;


	public ConcurrenteServidorHilo(Socket client, int numero,Respuestas respuestas) {
		this.client = client;
		this.numero=numero;
		this.respuestas=respuestas;
	}

	public void run(){

		PrintWriter fsalida=null;
		BufferedReader fentrada=null;
		String[] preguntas = {"¿Prefieres el azul o el rojo?","¿Prefieres Gatos o Perros?","¿Que deporte te gusta mas, Futbol o Baloncesto?","¿Eres mas de playa o de montaña?"};
		String respuesta="";
		try {
			fsalida= new PrintWriter(client.getOutputStream(),true);
			fentrada= new BufferedReader(new InputStreamReader(client.getInputStream()));
			for(int i =1; i<=4;i++) {


				fsalida.println(preguntas[i-1]);

				respuesta=fentrada.readLine();
				respuestas.setRespuesta(i, respuesta);

			}
			fsalida.println(respuestas);
			System.out.println(respuestas);
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
	
	

}
