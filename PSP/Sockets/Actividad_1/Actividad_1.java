package Actividad_1;
import java.net.InetAddress;
import java.net.UnknownHostException;

import entrada.Teclado;

public class Actividad_1 {

	public static void main(String[] args) {
		InetAddress dir = null; 
		String cadena = Teclado.leerCadena("Dime el nombre del equipo o la ip: ");
		String conexion[]=cadena.split(".");
		try {
			if(conexion.length==4) {
				 byte[] ipAddr = new byte[] { (byte) Integer.parseInt(conexion[0]), (byte) Integer.parseInt(conexion[1]), (byte) Integer.parseInt(conexion[2]), (byte) Integer.parseInt(conexion[3]) }; 
				 dir = InetAddress.getByAddress(ipAddr);
				 pruebaMetodos(dir);
			}if(conexion.length==0) {
				dir = InetAddress.getByName(cadena); 
				pruebaMetodos(dir);
			}
			
		} catch (UnknownHostException e) {
			System.err.println("El nombre del equipo o la ip no es correcta");
		} 
		
	}
	
	private static void pruebaMetodos(InetAddress dir) { 
		try {
			System.out.println("\tMetodo getLocalHost(): " + dir.getLocalHost());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("\tNombre del HOST: "+dir.getHostName()); 
		System.out.println("\tIP del HOST: "+ dir.getHostAddress()); 

	}

}
