package Actividad_4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import entrada.Teclado;

public class Actividad1x04Cliente {

	public static void main(String[] args) {
		Socket cliente=null;
		String host = "localhost"; 
		int puerto = 60000;//puerto remoto 
		String texto="";
		// ABRIR SOCKET 
		try {
			cliente = new Socket(host, puerto);
			BufferedReader flujoEntrada = null;

			try {
				File fichero = new File("data\\texto");
				flujoEntrada = new BufferedReader(new FileReader(fichero));
	      		String linea = flujoEntrada.readLine(); 
	      		while (linea != null) { 	 
	      			texto+=linea+"\n";
	      			linea = flujoEntrada.readLine();
	      		}
			}
			catch (FileNotFoundException fnfe) {                      
				System.out.println("Error al abrir el fichero:");
				System.out.println(fnfe.getMessage());
				fnfe.printStackTrace();
			}
			catch (IOException ioe) {
				System.out.println("Error al leer del fichero:");
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			}
			finally {
				try {
					if (flujoEntrada != null) {
						flujoEntrada.close();
					}
				}
				catch (IOException ioe) {
					System.out.println("Error al cerrar el fichero:");
					System.out.println(ioe.getMessage());
					ioe.printStackTrace();
				}
			}
			
			DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream()); 
			flujoSalida.writeUTF(texto);
		
			
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
