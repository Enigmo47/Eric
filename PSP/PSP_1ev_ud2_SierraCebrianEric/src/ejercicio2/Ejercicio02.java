package ejercicio2;

import java.time.LocalDateTime;

public class Ejercicio02 {
	
	public static void main(String[] args) throws InterruptedException {
		Turno turno = new Turno(2);
		System.out.println("-------> Estación abierta "+ LocalDateTime.now().toLocalTime());
		for(int i =1;i<=5;i++) {
			Coche coche=new Coche(i, turno);
			coche.start();
		}
		Thread.sleep(10000);
		System.out.println("<------- Estacion cerrada "+ LocalDateTime.now().toLocalTime());
		
	}
	
}
