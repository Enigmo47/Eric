package ActividadEntrevista;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import entrada.Teclado;

public class ConcurrenteCliente {

	public static void main(String[] args) {
		Socket cliente=null;
		String host = "localhost"; 
		int puerto = 60000;//puerto remoto 

		// ABRIR SOCKET 
		try {
			cliente = new Socket(host, puerto);
			PrintWriter flujoSalida= new PrintWriter(cliente.getOutputStream(),true);
			BufferedReader flujoEntrada= new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			String respuesta="";
			String pregunta="";

			
			for(int i =0;i<4;i++) {
				
			
				pregunta=flujoEntrada.readLine();
				System.out.println(pregunta); 
				
				respuesta=Teclado.leerCadena("Dime la cadena de texto: ");
				flujoSalida.println(respuesta);
				
			}
			String[] salida=flujoEntrada.readLine().split("☺"); 
			for(String s: salida) {
				System.out.println(s);
			}
			System.out.println("Gracias por realizar nuestra encuesta");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				cliente.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
