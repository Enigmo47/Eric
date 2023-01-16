package ejercicio1;

import java.util.concurrent.Semaphore;

public class Paciente extends Thread {

	int id;
	Semaphore salir;
	Semaphore atender;

	/*
	 * Un semáforo para si le ateienden y otro para ver si puede salir
	 */
	Paciente(Semaphore atender, Semaphore salir, int id) {
		this.id = id;
		this.salir = salir;
		this.atender = atender;
	}

	public void run() {

		try {
			System.out.println("Cliente " + id + " espera su turno");
			atender.release(); // entra un cliente

			System.out.println("Cliente " + id + " entra a la consulta");

			salir.acquire();// espera a poder salir
			System.out.println("Cliente " + id + " sale de la consulta");

		} catch (InterruptedException e) {
			System.out.println("ClaseSumar interrumpida");
		}
	}

}
