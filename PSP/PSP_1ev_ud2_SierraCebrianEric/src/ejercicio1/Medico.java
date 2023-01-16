package ejercicio1;

//import java.util.Random;
import java.util.concurrent.Semaphore;

public class Medico extends Thread {

	int tiempoTotal;
	Semaphore atender;
	Semaphore salir;
	int[] tiempo = { 100, 110, 150, 210, 250 };
	/*
	 * total de caja que hace, tiempo usara mismos
	 */

	Medico(Semaphore atender, Semaphore salir, int tiempo) {
		this.atender = atender;
		this.salir = salir;
	}

	public void run() {
		try {
			while (true) { // trabaja indefinidamente

				// Random r = new Random(5);//intento falido de realizarlo con la clase Random
				// al no poder parsearlo
				int ran = (int) (Math.random() * 5);
				int e = tiempo[ran];
				// int ra = (int) r;//intento falido de realizarlo con la clase Random al no
				// poder parsearlo
				atender.acquire();// espera a tener un paciente
				Thread.sleep(tiempo[ran]);
				tiempoTotal += e;
				salir.release();// saca a un paciente
				System.out.println("Tiempo de atencion: " + e);
			}

		} catch (InterruptedException e) {
			System.out.println("Medico finaliza consulta. Tiempo total: " + tiempoTotal);
		}

	}

}
