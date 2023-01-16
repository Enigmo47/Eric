package ejercicio1;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Ejercicio01 {

	public static void main(String[] args) {
		Paciente p = null;
		Semaphore atender = new Semaphore(0);
		Semaphore salir = new Semaphore(0);
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		Medico m = new Medico(atender, salir, 1);
		m.start();

		for (int i = 1; i < 4; i++) {
			p = new Paciente(atender, salir, i);
			pacientes.add(p);
			p.start();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (Paciente paciente : pacientes) {
			try {
				paciente.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		m.interrupt();

	}

}
