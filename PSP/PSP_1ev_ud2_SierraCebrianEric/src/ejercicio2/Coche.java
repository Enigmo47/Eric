package ejercicio2;

import java.util.Random;

public class Coche extends Thread {

	/*
	 * Cosa que entra. numero de puesto = posicion del vector
	 * 
	 * recurso compartido= Turno
	 * 
	 * 
	 */
	private int id;
	private Turno turno;

	Coche(int id, Turno turno) {
		this.id = id;
		this.turno = turno;
	}

	public void run() {
		try {
			Random random = new Random();
			Thread.sleep(random.nextInt(100, 1500));
			System.out.println("Coche " + id + " en cola");
			int puesto = turno.entrada(id);
			System.out.println("Coche " + id + " es atendido");
			Thread.sleep(random.nextInt(100, 1500));
			turno.salida(puesto);
			System.out.println("Coche " + id + " ha salido");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
