package ActividadConcurrente;

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
			String pregunta="";
			String respuesta="";

			
			for(int i =0;i<3;i++) {
				pregunta=Teclado.leerCadena("Dime la cadena de texto: ");
				System.out.print("Se envia: "+pregunta+"\n");
				flujoSalida.println(pregunta);
			
				respuesta=flujoEntrada.readLine();
				System.out.println(respuesta); 
			}

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
